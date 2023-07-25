package parkingLot_Practice.services;

import parkingLot_Practice.models.*;
import parkingLot_Practice.models.exceptions.GateNotFoundException;
import parkingLot_Practice.repositories.GateRepository;
import parkingLot_Practice.repositories.ParkingLotRepository;
import parkingLot_Practice.repositories.TicketRepository;
import parkingLot_Practice.repositories.VehicleRepository;
import parkingLot_Practice.strategies.spotAssignmentStrategy.SpotAssigmentStrategyFactory;
import parkingLot_Practice.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService{
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(
            VehicleType vehicleType,
        String vehicleNumber,
        String vehicleOwnerName,
        Long gateId
    ) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }

        Gate gate = gateOptional.get();
        ticket.setGeneratedAt(gate);

        Vehicle savedVehicle;

        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByNumber(vehicleNumber);
        if(vehicleOptional.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);

            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }
        else{
            savedVehicle = vehicleOptional.get();
        }

        ticket.setVehicle(savedVehicle);
        ticket.setGeneratedBy(gate.getCurrentOperator());

        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLotRepository.getParkingLotForGate(gate).getSpotAssignmentStrategyType();
        ParkingSpot parkingSpot = SpotAssigmentStrategyFactory.getSpotForType(spotAssignmentStrategyType).getSpot(gate, vehicleType);
        ticket.setAssignedSpot(parkingSpot);
        ticket.setNumber("TICKET-" + ticket.getId());

        Ticket savedTicket = ticketRepository.saveTicket(ticket);
        return savedTicket;
    }
}

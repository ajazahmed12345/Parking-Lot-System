package parkingLot_Practice.models;

import parkingLot_Practice.controllers.TicketController;
import parkingLot_Practice.repositories.GateRepository;
import parkingLot_Practice.repositories.ParkingLotRepository;
import parkingLot_Practice.repositories.TicketRepository;
import parkingLot_Practice.repositories.VehicleRepository;
import parkingLot_Practice.services.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Server is now listening at: 1000");

    }
}

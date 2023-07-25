package parkingLot_Practice.strategies.spotAssignmentStrategy;

import parkingLot_Practice.models.*;
import parkingLot_Practice.repositories.ParkingLotRepository;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy{
    // parkingSpotRepository
    private ParkingLotRepository parkingLotRepository;

    public NearestSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotForGate(gate);
        for(ParkingFloor parkingFloor : parkingLot.getFloors()){
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
                if(parkingSpot.getVehicleTypes().contains(vehicleType) && parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)){
                    return parkingSpot;
                }
            }
        }

        return null;
    }
}

package parkingLot_Practice.strategies.spotAssignmentStrategy;

import parkingLot_Practice.models.Gate;
import parkingLot_Practice.models.ParkingSpot;
import parkingLot_Practice.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot getSpot(Gate gate, VehicleType vehicleType);
}

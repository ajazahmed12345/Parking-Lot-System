package parkingLot_Practice.repositories;

import parkingLot_Practice.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicles = new TreeMap<>();
    private Long prevId = 0L;
    public Optional<Vehicle> getVehicleByNumber(String number){
        for(Vehicle vehicle : vehicles.values()){
            if(vehicle.getVehicleNumber() == number){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }
    public Vehicle saveVehicle(Vehicle vehicle){
        prevId++;
        vehicle.setId(prevId);
        vehicles.put(prevId, vehicle);

        return vehicle;
    }
}

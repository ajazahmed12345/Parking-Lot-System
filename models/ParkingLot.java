package parkingLot_Practice.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private List<VehicleType> vehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeesCalcStrategyType feesCalcStrategyType;

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }

    public FeesCalcStrategyType getFeesCalcStrategyType() {
        return feesCalcStrategyType;
    }

    public void setFeesCalcStrategyType(FeesCalcStrategyType feesCalcStrategyType) {
        this.feesCalcStrategyType = feesCalcStrategyType;
    }
}

package parkingLot_Practice.strategies.spotAssignmentStrategy;

import parkingLot_Practice.models.SpotAssignmentStrategyType;

public class SpotAssigmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotForType(SpotAssignmentStrategyType type){
        return new NearestSpotAssignmentStrategy(null);
    }
}

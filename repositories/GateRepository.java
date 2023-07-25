package parkingLot_Practice.repositories;


import parkingLot_Practice.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();
    public Optional<Gate> findGateById(Long id){
        if(gates.containsKey(id)){
            return Optional.of(gates.get(id));
        }

        return Optional.empty();
    }
}

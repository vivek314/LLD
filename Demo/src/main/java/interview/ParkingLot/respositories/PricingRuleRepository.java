package interview.ParkingLot.respositories;

import interview.ParkingLot.domain.PricingRule;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import interview.ParkingLot.domain.VehicleType;

public class PricingRuleRepository {
    private Map<UUID, PricingRule> pricingRuleMap = new ConcurrentHashMap<>();

    public PricingRule save(PricingRule pricingRule){
        pricingRuleMap.put(pricingRule.getId(), pricingRule);
        return pricingRule;
    }

    public Optional<PricingRule> findById(UUID id){
        return Optional.ofNullable(pricingRuleMap.get(id));
    }

    public void update(PricingRule pricingRule){
        pricingRuleMap.put(pricingRule.getId(), pricingRule);
    }

    public Optional<PricingRule> findByVehicleType(VehicleType vechicleType){
        Optional<PricingRule> result = pricingRuleMap.values().
                stream().
                filter(rule -> rule.getVehicleType().equals(vechicleType)).
                findFirst();
        return result;
    }

}

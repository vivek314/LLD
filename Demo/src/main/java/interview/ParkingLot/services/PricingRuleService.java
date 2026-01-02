package interview.ParkingLot.services;

import interview.ParkingLot.domain.PricingRule;
import interview.ParkingLot.domain.Ticket;
import interview.ParkingLot.domain.VehicleType;
import interview.ParkingLot.respositories.PricingRuleRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class PricingRuleService {
    private PricingRuleRepository pricingRuleRepository;
    public PricingRuleService(PricingRuleRepository pricingRuleRepository) {
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public double calculateTotalPrice(Ticket ticket){
        VehicleType vehicleType = VehicleType.CAR;
        Optional<PricingRule> rule = pricingRuleRepository.findByVehicleType(vehicleType);
        if(rule.isPresent()) {
            PricingRule pricingRule = rule.get();
            int totalHours = 3;
            return Math.min(totalHours*rule.get().getPricePerHour(), rule.get().getFlatRate());
        } else{
            throw new RuntimeException("No PricingRule found for VehicleType " + vehicleType.name());
        }
    }

    public void addPricingRule(PricingRule pricingRule){
        pricingRuleRepository.save(pricingRule);
    }
}

package interview.ParkingLot.services;

import interview.ParkingLot.domain.ParkingFloor;
import interview.ParkingLot.domain.ParkingSlot;
import interview.ParkingLot.domain.PricingRule;
import interview.ParkingLot.domain.VehicleType;
import interview.ParkingLot.respositories.FloorRepository;
import interview.ParkingLot.respositories.PricingRuleRepository;
import interview.ParkingLot.respositories.SlotRepository;

import java.util.Optional;
import java.util.UUID;

public class AdminService {
    private FloorRepository floorRepository;
    private SlotRepository slotRepository;
    private PricingRuleRepository pricingRuleRepository;
    public AdminService(FloorRepository floorRepository,  SlotRepository slotRepository, PricingRuleRepository pricingRuleRepository) {
        this.floorRepository = floorRepository;
        this.slotRepository = slotRepository;
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public void initializeParkingLot(){
        //Added floors
        for(int i=0;i<3;i++){
            addFloor(i);
        }
        //Add slots to the floor
        addSlotsToTheFloor(0, 10, VehicleType.TRUCK);
        addSlotsToTheFloor(1, 20, VehicleType.CAR);
        addSlotsToTheFloor(2, 30, VehicleType.BIKE);

        initializeDefaultPricingRules();

    }

    public void addFloor(int i){
        if(floorRepository.containsKey(i)){
            throw new IllegalArgumentException("Floor with id "+i+" already exists");
        }
        ParkingFloor floor = new ParkingFloor(i);
        floorRepository.save(floor);
    }

    private void initializeDefaultPricingRules() {
        System.out.println("[REPOSITORY] Initializing default pricing rules");

        PricingRule bikeRule = new PricingRule(VehicleType.BIKE, 10.0, 30.0);
        PricingRule carRule = new PricingRule(VehicleType.CAR, 20.0, 60.0);
        PricingRule truckRule = new PricingRule(VehicleType.TRUCK, 30.0, 90.0);

        pricingRuleRepository.save(bikeRule);
        pricingRuleRepository.save(carRule);
        pricingRuleRepository.save(truckRule);
    }

    public void addSlotsToTheFloor(int floorNumber, int numberOfSlots, VehicleType vehicleType){
        Optional<ParkingFloor> floor = floorRepository.findByFloorNumber(floorNumber);
        if(floor.isPresent()){
            ParkingFloor parkingFloor = floor.get();
            for(int i=0;i<numberOfSlots;i++) {
                ParkingSlot slot = new ParkingSlot(floorNumber, vehicleType);
                parkingFloor.addParkingSlot(slot);
                slotRepository.save(slot);
            }
        }
    }

    public void updatePricingRule(VehicleType vehicleType, double pricePerHour, double flatRate){
        Optional<PricingRule> rule = pricingRuleRepository.findByVehicleType(vehicleType);
        if(rule.isPresent()){
            PricingRule pricingRule = rule.get();
            pricingRule.setFlatRate(flatRate);
            pricingRule.setHourlyRate(pricePerHour);
            pricingRuleRepository.update(pricingRule);
        }
    }

    public void addPricingRule(PricingRule pricingRule){
        pricingRuleRepository.save(pricingRule);
    }

}

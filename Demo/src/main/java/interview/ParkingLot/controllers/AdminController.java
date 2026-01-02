package interview.ParkingLot.controllers;

import interview.ParkingLot.domain.PricingRule;
import interview.ParkingLot.domain.VehicleType;
import interview.ParkingLot.respositories.FloorRepository;
import interview.ParkingLot.services.AdminService;

public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    public void initializeParkingLot(){
        adminService.initializeParkingLot();
    }

    public void addFloor(int floor){
        adminService.addFloor(floor);
    }

    public void updatePricingRule(VehicleType vehicleType, double pricePerHour, double flatRate){
        adminService.updatePricingRule(vehicleType, pricePerHour, flatRate);
    }

    public void addPricingRule(PricingRule pricingRule){
        adminService.addPricingRule(pricingRule);
    }

    public void addSlotsToFloor(int floorNumber,VehicleType vehicleType, int numberOfSlots){
        adminService.addSlotsToTheFloor(floorNumber, numberOfSlots, vehicleType);
    }
}

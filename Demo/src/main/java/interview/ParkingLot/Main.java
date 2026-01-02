package interview.ParkingLot;

import interview.ParkingLot.controllers.AdminController;
import interview.ParkingLot.controllers.EntryController;
import interview.ParkingLot.controllers.ExitController;
import interview.ParkingLot.domain.PricingRule;
import interview.ParkingLot.domain.Ticket;
import interview.ParkingLot.domain.VehicleType;
import interview.ParkingLot.respositories.*;
import interview.ParkingLot.services.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PARKING LOT LLD SIMULATION ===");
        System.out.println("This simulation demonstrates the complete parking lot system flow\n");

        // Initialize repositories
        TicketRepository ticketRepository = new TicketRepository();
        SlotRepository slotRepository = new SlotRepository();
        FloorRepository floorRepository = new FloorRepository();
        PricingRuleRepository pricingRuleRepository = new PricingRuleRepository();
        TransactionRepository paymentRepository = new TransactionRepository();
        RecieptRepository recieptRepository = new RecieptRepository();

        // Initialize services
        TicketService ticketService = new TicketService(ticketRepository);
        SlotService slotService = new SlotService(slotRepository);
        PricingRuleService pricingService = new PricingRuleService(pricingRuleRepository);
        TransactionSevice paymentService = new TransactionSevice(paymentRepository);
        RecieptService receiptService = new RecieptService(recieptRepository);
        AdminService adminService = new AdminService(floorRepository, slotRepository, pricingRuleRepository);

        // Initialize controllers
        EntryController entryController = new EntryController(ticketService, slotService);
        ExitController exitController = new ExitController(ticketService, pricingService, paymentService, receiptService, slotService);
        AdminController adminController = new AdminController(adminService);

        // === INITIALIZATION PHASE ===
        System.out.println("=== INITIALIZATION PHASE ===");
        adminController.initializeParkingLot();

        // === ENTRY FLOW SIMULATION ===
        System.out.println("\n=== ENTRY FLOW SIMULATION ===");

        // Simulate vehicle entries
        simulateVehicleEntry(entryController, "ABC123", VehicleType.CAR);
        simulateVehicleEntry(entryController, "XYZ789", VehicleType.BIKE);
        simulateVehicleEntry(entryController, "DEF456", VehicleType.TRUCK);

        // === EXIT FLOW SIMULATION ===
        System.out.println("\n=== EXIT FLOW SIMULATION ===");

        // Get active tickets for exit simulation
        List<UUID> activeTickets = ticketRepository.getActiveTickets().stream()
                .map(Ticket::getId).collect(Collectors.toList());

        System.out.println("[REPOSITORY] Found " + activeTickets.size() + " active tickets");

        // Simulate vehicle exits
        for (UUID ticketId : activeTickets) {
            simulateVehicleExit(exitController, ticketId);
        }

        // === ADMIN OPERATIONS SIMULATION ===
        System.out.println("\n=== ADMIN OPERATIONS SIMULATION ===");
        simulateAdminOperations(adminController);


        System.out.println("\n=== SIMULATION COMPLETED ===");
    }

    private static void simulateVehicleEntry(EntryController entryController, String licensePlate, VehicleType vehicleType) {
        System.out.println("\n--- Vehicle Entry Simulation ---");
        EntryController.EntryResult result = entryController.enterVehicle(licensePlate, vehicleType);

        if (result.isSuccess()) {
            System.out.println("✅ Entry successful - Ticket ID: " + result.getTicketId());
        } else {
            System.out.println("❌ Entry failed: " + result.getMessage());
        }
    }

    private static void simulateVehicleExit(ExitController exitController, UUID ticketId) {
        System.out.println("\n--- Vehicle Exit Simulation ---");
        ExitController.ExitResult result = exitController.exitVehicle(ticketId);

        if (result.isSuccess()) {
            System.out.println("✅ Exit successful - Receipt ID: " + result.getRecieptId());
            System.out.println("💳 Payment Status: SUCCESS");

        } else {
            System.out.println("❌ Exit failed: " + result.getMessage());
        }
    }

    private static void simulateAdminOperations(AdminController adminController) {
        System.out.println("\n--- Admin Operations Simulation ---");

        // Add a new floor
        adminController.addFloor(3);

        // Add slots to the new floor
        adminController.addSlotsToFloor(3, VehicleType.CAR, 10);
        adminController.addSlotsToFloor(3, VehicleType.TRUCK, 5);

        // Update pricing for CAR
        adminController.updatePricingRule(VehicleType.CAR, 25.0, 60.0);

        // Add a new pricing rule for EV
        PricingRule newEvRule = new PricingRule(VehicleType.TRUCK, 18.0, 50.0);
        adminController.addPricingRule(newEvRule);

        System.out.println("✅ Admin operations completed successfully");
    }
}

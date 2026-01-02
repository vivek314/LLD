package interview.ParkingLot.controllers;

import creational.FactoryPattern.Vehicle;
import interview.ParkingLot.domain.Reciept;
import interview.ParkingLot.domain.Ticket;
import interview.ParkingLot.domain.Transaction;
import interview.ParkingLot.payment.PaymentGatewayAdapter;
import interview.ParkingLot.payment.StripePaymentAdapter;
import interview.ParkingLot.services.*;

import java.util.Optional;
import java.util.UUID;

public class ExitController {
    private TransactionSevice paymentService;
    private PricingRuleService pricingService;
    private TicketService ticketService;
    private SlotService slotService;
    private RecieptService recieptService;

    public ExitController(TicketService ticketService, PricingRuleService pricingService, TransactionSevice transactionSevice, RecieptService recieptService, SlotService slotService){
        this.paymentService = transactionSevice;
        this.pricingService = pricingService;
        this.ticketService = ticketService;
        this.slotService = slotService;
        this.recieptService = recieptService;
    }

    public static class ExitResult{
        boolean success;
        String message;
        private UUID recieptId;
        public ExitResult(boolean success, String message, UUID recieptId){
            this.success = success;
            this.message = message;
            this.recieptId = recieptId;
        }

        public UUID getRecieptId(){
            return recieptId;
        }

        public boolean isSuccess(){
            return success;
        }

        public String getMessage(){
            return message;
        }
    }
    public ExitResult exitVehicle(UUID ticketUuid){
        Optional<Ticket> ticketOptional = ticketService.findById(ticketUuid);
        if(ticketOptional.isPresent()){
            Ticket ticket = ticketOptional.get();
            double totalPrice = pricingService.calculateTotalPrice(ticket);
            //payment
            boolean isSuccess = paymentService.processPayment(totalPrice, ticketUuid);
            if(!isSuccess){
                return new ExitResult(false, "payment not failed", null);
            }
            Reciept reciept = recieptService.generateReciept(ticketUuid, totalPrice);
            recieptService.markRecieptAsPaid(reciept);

            slotService.releaseSlot(ticket.getSlotId());

            ticketService.deactivateTicket(ticketUuid);

            return new ExitResult(true, "success", reciept.getId());
        } else{
            return new ExitResult(false, "Ticket not found", null);
        }
    }
}

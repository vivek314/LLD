package interview.ParkingLot.domain;

import interview.ParkingLot.payment.PaymentGatewayAdapter;

import java.util.UUID;

public class Transaction {
    private UUID id;
    private UUID ticketId;
    private double price;
    private PaymentGatewayAdapter paymentGatewayAdapter;
    private PaymentStatus paymentStatus;

    public enum PaymentGatewayAdapterType {
        RAZORPAY, STRIPE
    }
    public Transaction(UUID ticketId, double price, PaymentGatewayAdapter paymentGatewayAdapter) {
        this.ticketId = ticketId;
        this.price = price;
        this.paymentGatewayAdapter = paymentGatewayAdapter;
        this.paymentStatus = PaymentStatus.PENDING;
        this.id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }
    public void markAsPaid() {
        this.paymentStatus = PaymentStatus.SUCCESS;
    }
    public UUID getTicketId() {
        return ticketId;
    }
    public double getPrice() {
        return price;
    }
    public PaymentGatewayAdapter getPaymentGatewayAdapter() {
        return paymentGatewayAdapter;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void markAsFailed() {
        this.paymentStatus = PaymentStatus.FAILURE;
    }
}

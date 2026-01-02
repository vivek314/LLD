package interview.ParkingLot.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reciept {
    private UUID uuid;
    private UUID ticketUuid;
    private LocalDateTime exitTime;
    private final double price;
    private PaymentStatus paymentStatus;

    public Reciept(UUID ticketUuid, double price) {
        this.ticketUuid = ticketUuid;
        this.price = price;
        this.exitTime = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
        this.uuid = UUID.randomUUID();
    }

    public UUID getTicketUuid() {
        return ticketUuid;
    }

    public void markAsSuccess() {
        this.paymentStatus = PaymentStatus.SUCCESS;
    }
    public void markAsFailure() {
        this.paymentStatus = PaymentStatus.FAILURE;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public UUID getId(){
        return uuid;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }



}

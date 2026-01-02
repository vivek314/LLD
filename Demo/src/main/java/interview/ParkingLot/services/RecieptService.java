package interview.ParkingLot.services;

import interview.ParkingLot.domain.Reciept;
import interview.ParkingLot.respositories.RecieptRepository;

import java.util.Map;
import java.util.UUID;

public class RecieptService {
    private RecieptRepository recieptRepository;
    public RecieptService(RecieptRepository recieptRepository) {
        this.recieptRepository = recieptRepository;
    }

    public Reciept generateReciept(UUID ticketUuid, double price){
        System.out.println("Generating Reciept for Ticket: " + ticketUuid);
        Reciept reciept = new Reciept(ticketUuid, price);
        recieptRepository.save(reciept);
        System.out.println("Saved Reciept for Ticket: " + ticketUuid);
        return reciept;
    }

    public void markRecieptAsPaid(Reciept reciept){
        reciept.markAsSuccess();
        System.out.println("Marking Reciept as Paid: " + reciept.getId());
        return;
    }
}

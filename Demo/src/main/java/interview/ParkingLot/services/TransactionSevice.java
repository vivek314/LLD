package interview.ParkingLot.services;

import interview.ParkingLot.domain.PaymentStatus;
import interview.ParkingLot.domain.Transaction;
import interview.ParkingLot.payment.PaymentGatewayAdapter;
import interview.ParkingLot.payment.RazorPayAdapter;
import interview.ParkingLot.respositories.TransactionRepository;

import java.util.UUID;

public class TransactionSevice {
    private TransactionRepository  transactionRepository;
    private PaymentGatewayAdapter paymentGatewayAdapter;

    public TransactionSevice(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.paymentGatewayAdapter = new RazorPayAdapter();
    }

    public Transaction generateTransaction(UUID ticketId, double price, PaymentGatewayAdapter paymentGatewayAdapter) {
        Transaction transaction = new Transaction(ticketId, price, paymentGatewayAdapter);
        System.out.println("Generated transaction: "+ transaction.getId());
        transactionRepository.save(transaction);
        System.out.println("Saved transaction: "+ transaction.getId());
        return transaction;
    }

    public boolean processPayment(double price, UUID ticketId){
        Transaction transaction = generateTransaction(ticketId, price, paymentGatewayAdapter);
        boolean result = paymentGatewayAdapter.pay(price);
        if(result){
            transaction.markAsPaid();
        } else{
            transaction.markAsFailed();
        }
        transactionRepository.update(transaction);
        return result;
    }


}

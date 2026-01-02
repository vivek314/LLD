package interview.ParkingLot.respositories;

import interview.ParkingLot.domain.Transaction;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class TransactionRepository {
    private Map<UUID, Transaction> transactionMap;
    private Map<UUID, List<UUID>> ticketToTransaction;

    public TransactionRepository() {
        transactionMap = new ConcurrentHashMap<>();
        ticketToTransaction = new ConcurrentHashMap<>();
    }

    public Transaction save(Transaction transaction) {
        transactionMap.put(transaction.getId(), transaction);
        return transaction;
    }

    public Optional<Transaction> findById(UUID id) {
        return Optional.ofNullable(transactionMap.get(id));
    }

    public List<Transaction> findByTicketId(UUID ticketId) {
        List<UUID> transactionIds = ticketToTransaction.get(ticketId);
        if(!transactionIds.isEmpty()){
            return transactionIds.stream().
                    map(uuid -> transactionMap.get(uuid)).
                    collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public void update(Transaction tranaction){
        if(transactionMap.containsKey(tranaction.getId())){
            transactionMap.put(tranaction.getId(), tranaction);
        }
    }

}

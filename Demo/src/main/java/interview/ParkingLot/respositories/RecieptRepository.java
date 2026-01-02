package interview.ParkingLot.respositories;

import interview.ParkingLot.domain.Reciept;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RecieptRepository {
    private Map<UUID, Reciept> recieptMap;

    public RecieptRepository() {
        recieptMap = new ConcurrentHashMap<>();
    }

    public Reciept save(Reciept reciept) {
        recieptMap.put(reciept.getId(), reciept);
        return reciept;
    }

    public Optional<Reciept> findById(UUID id) {
        return  Optional.ofNullable(recieptMap.get(id));
    }
}

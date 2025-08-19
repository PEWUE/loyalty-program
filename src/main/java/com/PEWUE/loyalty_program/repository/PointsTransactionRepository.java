package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.PointsTransaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PointsTransactionRepository {
    private final Map<Long, PointsTransaction> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public PointsTransaction save(PointsTransaction transaction) {
        if (transaction.getId() == null) {
            transaction.setId(idCounter.incrementAndGet());
        }
        storage.put(transaction.getId(), transaction);
        return transaction;
    }

    public Optional<PointsTransaction> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<PointsTransaction> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}

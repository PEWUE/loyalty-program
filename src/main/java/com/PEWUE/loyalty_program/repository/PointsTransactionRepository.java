package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.PointsTransaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PointsTransactionRepository {
    private final List<PointsTransaction> storage = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public PointsTransaction save(PointsTransaction transaction) {
        if (transaction.getId() == null) {
            transaction.setId(idCounter.incrementAndGet());
        }
        storage.add(transaction);
        return transaction;
    }

    public Optional<PointsTransaction> findById(Long id) {
        return storage.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst();
    }

    public List<PointsTransaction> findAll() {
        return new ArrayList<>(storage);
    }

    public void deleteById(Long id) {
        storage.removeIf(transaction -> transaction.getId().equals(id));
    }
}

package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.LoyaltyProgram;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LoyaltyProgramRepository {
    private final Map<Long, LoyaltyProgram> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public LoyaltyProgram save(LoyaltyProgram program) {
        if (program.getId() == null) {
            program.setId(idCounter.incrementAndGet());
        }
        storage.put(program.getId(), program);
        return program;
    }

    public Optional<LoyaltyProgram> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<LoyaltyProgram> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public Optional<LoyaltyProgram> findByName(String name) {
        return storage.values().stream()
                .filter(program -> program.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}

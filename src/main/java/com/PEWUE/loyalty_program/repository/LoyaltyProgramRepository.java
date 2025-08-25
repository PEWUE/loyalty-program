package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.LoyaltyProgram;
import com.PEWUE.loyalty_program.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class LoyaltyProgramRepository {
    private final List<LoyaltyProgram> storage = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public LoyaltyProgram save(LoyaltyProgram program) {
        if (program.getId() == null) {
            program.setId(idCounter.incrementAndGet());
        }
        storage.add(program);
        return program;
    }

    public Optional<LoyaltyProgram> findById(Long id) {
        return storage.stream()
                .filter(program -> program.getId().equals(id))
                .findFirst();
    }

    public List<LoyaltyProgram> findAll() {
        return new ArrayList<>(storage);
    }

    public void deleteById(Long id) {
        storage.removeIf(program -> program.getId().equals(id));
    }

    public Optional<LoyaltyProgram> findByName(String name) {
        return storage.stream()
                .filter(program -> program.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public LoyaltyProgram updateProgram(LoyaltyProgram user, LoyaltyProgram updatedProgram) {
        return user.update(updatedProgram);
    }
}

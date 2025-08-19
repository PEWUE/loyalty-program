package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.Reward;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RewardRepository {
    private final List<Reward> storage = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Reward save(Reward reward) {
        if (reward.getId() == null) {
            reward.setId(idCounter.incrementAndGet());
        }
        storage.add(reward);
        return reward;
    }

    public Optional<Reward> findById(Long id) {
        return storage.stream()
                .filter(reward -> reward.getId().equals(id))
                .findFirst();
    }

    public List<Reward> findAll() {
        return new ArrayList<>(storage);
    }

    public void deleteById(Long id) {
        storage.removeIf(reward -> reward.getId().equals(id));
    }
}

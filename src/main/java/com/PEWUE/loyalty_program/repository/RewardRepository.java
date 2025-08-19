package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.Reward;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RewardRepository {
    private final Map<Long, Reward> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Reward save(Reward reward) {
        if (reward.getId() == null) {
            reward.setId(idCounter.incrementAndGet());
        }
        storage.put(reward.getId(), reward);
        return reward;
    }

    public Optional<Reward> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Reward> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}

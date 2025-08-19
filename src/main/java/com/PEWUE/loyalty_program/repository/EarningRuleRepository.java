package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.EarningRule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EarningRuleRepository {
    private final Map<Long, EarningRule> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public EarningRule save(EarningRule rule) {
        if (rule.getId() == null) {
            rule.setId(idCounter.incrementAndGet());
        }
        storage.put(rule.getId(), rule);
        return rule;
    }

    public Optional<EarningRule> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<EarningRule> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}

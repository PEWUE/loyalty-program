package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.EarningRule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EarningRuleRepository {
    private final List<EarningRule> storage = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public EarningRule save(EarningRule rule) {
        if (rule.getId() == null) {
            rule.setId(idCounter.incrementAndGet());
        }
        storage.add(rule);
        return rule;
    }

    public Optional<EarningRule> findById(Long id) {
        return storage.stream()
                .filter(rule -> rule.getId().equals(id))
                .findFirst();
    }

    public List<EarningRule> findAll() {
        return new ArrayList<>(storage);
    }

    public void deleteById(Long id) {
        storage.removeIf(rule -> rule.getId().equals(id));
    }
}

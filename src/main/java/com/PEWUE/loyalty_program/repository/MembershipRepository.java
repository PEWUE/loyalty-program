package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.Membership;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MembershipRepository {
    private final Map<Long, Membership> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Membership save(Membership membership) {
        if (membership.getId() == null) {
            membership.setId(idCounter.incrementAndGet());
        }
        storage.put(membership.getId(), membership);
        return membership;
    }

    public Optional<Membership> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Membership> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}

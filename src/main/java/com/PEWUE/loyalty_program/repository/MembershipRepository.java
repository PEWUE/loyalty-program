package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.Membership;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MembershipRepository {
    private final List<Membership> storage = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Membership save(Membership membership) {
        if (membership.getId() == null) {
            membership.setId(idCounter.incrementAndGet());
        }
        storage.add(membership);
        return membership;
    }

    public Optional<Membership> findById(Long id) {
        return storage.stream()
                .filter(membership -> membership.getId().equals(id))
                .findFirst();
    }

    public List<Membership> findAll() {
        return new ArrayList<>(storage);
    }

    public void deleteById(Long id) {
        storage.removeIf(membership -> membership.getId().equals(id));
    }
}

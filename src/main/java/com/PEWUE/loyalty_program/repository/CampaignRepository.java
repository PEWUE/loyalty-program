package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.Campaign;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CampaignRepository {
    private final List<Campaign> storage = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Campaign save(Campaign campaign) {
        if (campaign.getId() == null) {
            campaign.setId(idCounter.incrementAndGet());
        }
        storage.add(campaign);
        return campaign;
    }

    public Optional<Campaign> findById(Long id) {
        return storage.stream()
                .filter(campaign -> campaign.getId().equals(id))
                .findFirst();
    }

    public List<Campaign> findAll() {
        return new ArrayList<>(storage);
    }

    public void deleteById(Long id) {
        storage.removeIf(campaign -> campaign.getId().equals(id));
    }
}

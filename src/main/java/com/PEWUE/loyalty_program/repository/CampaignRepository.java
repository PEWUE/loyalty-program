package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.Campaign;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CampaignRepository {
    private final Map<Long, Campaign> storage = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Campaign save(Campaign campaign) {
        if (campaign.getId() == null) {
            campaign.setId(idCounter.incrementAndGet());
        }
        storage.put(campaign.getId(), campaign);
        return campaign;
    }

    public Optional<Campaign> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Campaign> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}

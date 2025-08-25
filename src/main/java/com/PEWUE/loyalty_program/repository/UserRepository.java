package com.PEWUE.loyalty_program.repository;

import com.PEWUE.loyalty_program.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final List<User> storage = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.incrementAndGet());
        }
        storage.add(user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return storage.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(storage);
    }

    public void deleteById(Long id) {
        storage.removeIf(user -> user.getId().equals(id));
    }

    public Optional<User> findByEmail(String email) {
        return storage.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public User updateUser(User user, User updatedUser) {
        return user.update(updatedUser);
    }
}

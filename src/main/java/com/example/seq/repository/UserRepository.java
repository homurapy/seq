package com.example.seq.repository;


import com.example.seq.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
 public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

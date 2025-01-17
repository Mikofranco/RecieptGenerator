package com.mikotech.Reciept.Generator.data.repo;

import com.mikotech.Reciept.Generator.data.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

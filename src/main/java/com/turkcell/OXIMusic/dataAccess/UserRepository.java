package com.turkcell.OXIMusic.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OXIMusic.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}

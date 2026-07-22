package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

	Optional<UserEntity> findByEmail(String email);

	List<UserEntity> findByUsernameContaining(String keyword);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

}

package com.example.demo.category.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.category.entity.CatEntity;

public interface CatDao extends JpaRepository<CatEntity, Long> {
	Optional<CatEntity> findByName(String name);

	List<CatEntity> findByDescription(String description);

	List<CatEntity> findByNameContaining(String keyword);

	boolean existsByName(String name);
}

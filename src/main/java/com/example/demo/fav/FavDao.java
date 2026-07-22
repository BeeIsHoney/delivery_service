package com.example.demo.fav;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.category.CatEntity;
import com.example.demo.user.UserEntity;

public interface FavDao extends JpaRepository<FavEntity, Long> {

    List<FavEntity> findByUser(UserEntity user);

    List<FavEntity> findByCategory(CatEntity category);

    boolean existsByUserAndCategory(UserEntity user, CatEntity category);

}
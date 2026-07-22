package com.example.demo.fav.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.category.entity.CatEntity;
import com.example.demo.fav.entity.FavEntity;
import com.example.demo.user.entity.UserEntity;

public interface FavDao extends JpaRepository<FavEntity, Long> {

    List<FavEntity> findByUser(UserEntity user);

    List<FavEntity> findByCategory(CatEntity category);

    boolean existsByUserAndCategory(UserEntity user, CatEntity category);

}
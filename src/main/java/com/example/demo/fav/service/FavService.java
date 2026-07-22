package com.example.demo.fav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.category.dao.CatDao;
import com.example.demo.category.entity.CatEntity;
import com.example.demo.fav.dao.FavDao;
import com.example.demo.fav.entity.FavEntity;
import com.example.demo.user.dao.UserDao;
import com.example.demo.user.entity.UserEntity;


@Service
public class FavService {


    private final FavDao favDao;
    private final UserDao userDao;
    private final CatDao catDao;


    public FavService(
            FavDao favDao,
            UserDao userDao,
            CatDao catDao) {

        this.favDao = favDao;
        this.userDao = userDao;
        this.catDao = catDao;
    }



    // Add favourite
    public FavEntity addFavourite(Long userId, Long categoryId) {


        UserEntity user = userDao.findById(userId)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));


        CatEntity category = catDao.findById(categoryId)
                .orElseThrow(() ->
                    new RuntimeException("Category not found"));



        if(favDao.existsByUserAndCategory(user, category)) {

            throw new RuntimeException(
                    "Already favourite");
        }


        FavEntity fav = new FavEntity();

        fav.setUser(user);
        fav.setCategory(category);


        return favDao.save(fav);
    }



    // Get all favourites
    public List<FavEntity> getAllFavourite() {

        return favDao.findAll();
    }



    // Get user's favourites
    public List<FavEntity> getUserFavourite(Long userId) {


        UserEntity user = userDao.findById(userId)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));


        return favDao.findByUser(user);
    }



    // Delete favourite
    public void deleteFavourite(Long id) {

        FavEntity fav = favDao.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Favourite not found"));


        favDao.delete(fav);
    }

}
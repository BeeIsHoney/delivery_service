package com.example.demo.fav.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.fav.entity.FavEntity;
import com.example.demo.fav.service.FavService;

@RestController
@RequestMapping("/favourites")
public class FavController {


    private final FavService favService;


    public FavController(FavService favService) {

        this.favService = favService;
    }



    // Add favourite
    @PostMapping("/{userId}/{categoryId}")
    public FavEntity addFavourite(
            @PathVariable Long userId,
            @PathVariable Long categoryId) {


        return favService.addFavourite(
                userId,
                categoryId);
    }



    // Get all favourites
    @GetMapping
    public List<FavEntity> getAllFavourite() {

        return favService.getAllFavourite();
    }



    // Get user's favourite categories
    @GetMapping("/user/{userId}")
    public List<FavEntity> getUserFavourite(
            @PathVariable Long userId) {


        return favService.getUserFavourite(userId);
    }



    // Delete favourite
    @DeleteMapping("/{id}")
    public String deleteFavourite(
            @PathVariable Long id) {


        favService.deleteFavourite(id);


        return "Favourite deleted successfully";
    }

}
package com.example.demo.category;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CatService {

    private final CatDao catDao;

    public CatService(CatDao catDao) {
        this.catDao = catDao;
    }

    // Create
    public CatEntity saveCategory(CatEntity category) {
        return catDao.save(category);
    }

    // Read all
    public List<CatEntity> getAllCategories() {
        return catDao.findAll();
    }

    // Read by ID
    public CatEntity getCategoryById(Long id) {
        return catDao.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found with id: " + id));
    }

    // Update
    public CatEntity updateCategory(Long id, CatEntity category) {

        CatEntity existingCategory = getCategoryById(id);

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        return catDao.save(existingCategory);
    }

    // Delete
    public void deleteCategory(Long id) {

        CatEntity category = getCategoryById(id);

        catDao.delete(category);
    }
}
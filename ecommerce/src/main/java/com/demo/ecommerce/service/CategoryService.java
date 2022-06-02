package com.demo.ecommerce.service;


import com.demo.ecommerce.model.Category;
import com.demo.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);

    }

    public void removeCategoryById(long categoryID) {
        categoryRepository.deleteById(categoryID);
    }

    public Optional<Category> getCategoryById(long id) {
        return categoryRepository.findById(id);
    }


    public boolean findById(Long categoryID) {
        return categoryRepository.findById(categoryID).isPresent();
    }

}

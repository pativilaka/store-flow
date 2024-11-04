package com.fiap.store_flow.services;

import com.fiap.store_flow.dto.CategoryDTO;
import com.fiap.store_flow.entities.Category;
import com.fiap.store_flow.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public List<CategoryDTO> findAll(){
        List<Category> categories = repository.findAll();
        List<CategoryDTO> categoriesDto = categories.stream().map(CategoryDTO::new).toList();
        return categoriesDto;
    }

}

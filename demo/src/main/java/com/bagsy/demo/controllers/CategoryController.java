package com.bagsy.demo.controllers;

import com.bagsy.demo.domain.category.Category;
import com.bagsy.demo.domain.category.CreateCategoryDTO;
import com.bagsy.demo.domain.category.UpdateCategoryDTO;
import com.bagsy.demo.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        var categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") String categoryId){
        var category = categoryService.getCategoryById(categoryId);
        if (category.isPresent()){
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryDTO createCategoryDTO){
        var categoryId = categoryService.createCategory(createCategoryDTO);
        return ResponseEntity.created(URI.create("/category/"+ categoryId.toString())).build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Void> updateCategoryById(@PathVariable("categoryId") String categoryId, @RequestBody UpdateCategoryDTO updateCategoryDTO){
        categoryService.updateCategoryById(categoryId, updateCategoryDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable("categoryId") String categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.noContent().build();
    }
}

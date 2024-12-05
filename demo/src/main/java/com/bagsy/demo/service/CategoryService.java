package com.bagsy.demo.service;

import com.bagsy.demo.domain.category.Category;
import com.bagsy.demo.domain.category.CategoryRepository;
import com.bagsy.demo.domain.category.CreateCategoryDTO;
import com.bagsy.demo.domain.category.UpdateCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public UUID createCategory(CreateCategoryDTO createCategoryDTO){
        var entity = new Category(
                UUID.randomUUID(),
                createCategoryDTO.nome(),
                createCategoryDTO.descricao(),
                createCategoryDTO.dataCriacao(),
                createCategoryDTO.dataAtualizacao()
        );
        var categorySaved = categoryRepository.save(entity);
        return categorySaved.getCategoriaId();
    }

    public Optional<Category> getCategoryById(String categoryId){
        var category = categoryRepository.findById(UUID.fromString(categoryId));
        return category;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategoryById(String categoryId){
        var id = UUID.fromString(categoryId);
        var categoryExists = categoryRepository.existsById(id);
        if (categoryExists){
            categoryRepository.deleteById(id);
        }
    }

    public void updateCategoryById(String categoryId, UpdateCategoryDTO updateCategoryDTO){
        var id = UUID.fromString(categoryId);
        var categoryEntity = categoryRepository.findById(id);
        if (categoryEntity.isPresent()){
            var newCategory = categoryEntity.get();
            if (updateCategoryDTO.nome() != null){
                newCategory.setNome(updateCategoryDTO.nome());
            }
            if (updateCategoryDTO.descricao() != null){
                newCategory.setNome(updateCategoryDTO.descricao());
            }
            categoryRepository.save(newCategory);
        }
    }

}

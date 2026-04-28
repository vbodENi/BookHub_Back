package fr.eni.bookhub_api.books;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.bookhub_api.common.dal.CategoryRepository;

@Service
public class CategoryService implements ICategoryBLL {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }


    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryDTO::new).toList();

    }
    
}

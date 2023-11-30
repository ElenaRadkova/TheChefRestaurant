package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Category;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.CategoryNameEnum;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.CategoryRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);

    }
}

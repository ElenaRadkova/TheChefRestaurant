package softuni.TheChefRestaurant.TheChefRestaurant.service;

import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Category;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {

    Category findCategoryByName(CategoryNameEnum categoryNameEnum);

}

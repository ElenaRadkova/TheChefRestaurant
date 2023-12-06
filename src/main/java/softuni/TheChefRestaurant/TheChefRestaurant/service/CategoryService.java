package softuni.TheChefRestaurant.TheChefRestaurant.service;

import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.CategoryEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    CategoryEntity findCategoryByName(CategoryNameEnum categoryNameEnum);

}

package softuni.TheChefRestaurant.TheChefRestaurant.model.entity;

import jakarta.persistence.*;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.CategoryNameEnum;

@Entity
@Table(name="categories")
public class CategoryEntity extends BaseEntity{
    private CategoryNameEnum name;
    private String description;

    public CategoryEntity() {
    }
   @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "LONGTEXT")
    public String getDescription() {
        return description;
    }
    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}

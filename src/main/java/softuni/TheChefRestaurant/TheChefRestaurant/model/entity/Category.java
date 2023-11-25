package softuni.TheChefRestaurant.TheChefRestaurant.model.entity;

import jakarta.persistence.*;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.CategoryNameEnum;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
    private CategoryNameEnum name;
    private String description;

    public Category() {
    }
   @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "LONGTEXT")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

package softuni.TheChefRestaurant.TheChefRestaurant.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.RoleNameEnum;

@Entity
@Table(name="roles")
public class Role extends BaseEntity {
    private RoleNameEnum name;

    public Role() {
    }
    @Enumerated(EnumType.STRING)
    public RoleNameEnum getName() {
        return name;
    }
    public void setName(RoleNameEnum name) {
        this.name = name;
    }
}

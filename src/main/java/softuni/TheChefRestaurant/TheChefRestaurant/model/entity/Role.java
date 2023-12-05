package softuni.TheChefRestaurant.TheChefRestaurant.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.RoleNameEnum;

@Entity
@Table(name="roles")
public class Role extends BaseEntity {
    public Role() {
    }
    private RoleNameEnum role;


    @Enumerated(EnumType.STRING)

    public RoleNameEnum getRole() {
        return role;
    }

    public void setRole(RoleNameEnum role) {
        this.role = role;
    }
}

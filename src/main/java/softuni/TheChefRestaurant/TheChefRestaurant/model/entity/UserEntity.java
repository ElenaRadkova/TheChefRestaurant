package softuni.TheChefRestaurant.TheChefRestaurant.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity{
    private String username;
    private String password;
    private String fullName;
    private String email;
//    private String phoneNumber;
    private Set<RoleEntity> roleEntities;


    public UserEntity() {
    }

  @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }
//    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<RoleEntity> getRoles() {
        return roleEntities;
    }

    public UserEntity setRoles(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
        return this;
    }


}

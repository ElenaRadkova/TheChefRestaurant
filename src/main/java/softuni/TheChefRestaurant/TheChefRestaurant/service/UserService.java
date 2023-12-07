package softuni.TheChefRestaurant.TheChefRestaurant.service;


import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findById(Long id);

    boolean isUsernameExists(String username);

    UserEntity findByUserId();

    void createUserIfNotExist(String email, String name);

//    Authentication login(String username);

}

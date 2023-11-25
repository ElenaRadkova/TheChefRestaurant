package softuni.TheChefRestaurant.TheChefRestaurant.service;

import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

 UserServiceModel findById(Long id);

    boolean isUsernameExists(String username);

    UserEntity findByUserId(Long id);

}

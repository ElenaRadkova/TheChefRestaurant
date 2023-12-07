package softuni.TheChefRestaurant.TheChefRestaurant.service;

import org.springframework.security.core.Authentication;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findById(Long id);

//    boolean isUsernameExists(String username);
//
//    UserEntity findByUserId();
//
    void createUserIfNotExist(String username, String password);

    Authentication login(String username);

}

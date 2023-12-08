package softuni.TheChefRestaurant.TheChefRestaurant.service;

import org.springframework.security.core.Authentication;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.RegisterUserDTO;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;

public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);

    UserServiceModel findById(Long id);
    boolean isUniqueUsername(String value);

    boolean isUniqueEmail(String value);

    void createUserIfNotExist(String username, String password);

    Authentication login(String username);

}

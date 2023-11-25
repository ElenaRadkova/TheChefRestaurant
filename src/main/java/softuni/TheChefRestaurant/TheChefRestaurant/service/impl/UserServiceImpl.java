package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.util.LoggedUser;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }
    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(user);
    }
    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                             .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                              .orElse(null);
    }
    @Override
    public void loginUser(Long id, String username) {
            loggedUser.setUsername(username);
            loggedUser.setId(id);
    }

    @Override
    public void logout() {
        loggedUser.setId(null);
        loggedUser.setUsername(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                              .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                              .orElse(null);

    }

    @Override
    public boolean isUsernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserEntity findByUserId(Long id) {
        return userRepository.findById(id).orElse(null);

    }

}

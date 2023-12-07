package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                              .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                              .orElse(null);
    }

    @Override
    public void createUserIfNotExist(String username, String password) {

    }

    @Override
    public Authentication login(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        return auth;
    }

//    @Override
//    public boolean isUsernameExists(String username) {
//        return userRepository.findByUsername(username).isPresent();
//    }
//
//    @Override
//    public UserEntity findByUserId() {
//        return userRepository.findById(findByUserId().getId()).orElse(null);
//    }
//
//    @Override
//    public void createUserIfNotExist(String email, String name) {
//    }
//    @Override
//    public Authentication login(String username) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//        Authentication auth = new UsernamePasswordAuthenticationToken(
//                userDetails,
//                userDetails.getPassword(),
//                userDetails.getAuthorities()
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//        return auth;
//    }

}

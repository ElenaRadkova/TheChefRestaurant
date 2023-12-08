package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.RegisterUserDTO;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.binding.UserRegisterBindingModel;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserDetailsService theChefUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserDetailsService userDetailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.theChefUserDetailsService = userDetailService;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void registerUser(
            RegisterUserDTO registerUserDTO) {

        userRepository.save(map(registerUserDTO));

//        appEventPublisher.publishEvent(new UserRegisteredEvent(
//                "UserService",
//                registerUserDTO.email(),
//                registerUserDTO.fullName()
//        ));
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                              .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                              .orElse(null);
    }

    @Override
    public boolean isUniqueUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public boolean isUniqueEmail(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public void createUserIfNotExist(String username, String password) {
    }

    @Override
    public Authentication login(String username) {
        UserDetails userDetails = theChefUserDetailsService.loadUserByUsername(username);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        return auth;
    }
    private UserEntity map(RegisterUserDTO registerUserDTO) {
        return new UserEntity()
                .setUsername(registerUserDTO.username())
                .setFullName(registerUserDTO.fullName())
                .setEmail(registerUserDTO.email())
                .setPassword(passwordEncoder.encode(registerUserDTO.password()));
    }


}

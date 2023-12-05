package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserDetailsService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TheChefUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public TheChefUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " was not found."));

        return map(userEntity);
    }
    private UserDetails map(UserEntity user) {
        Set<GrantedAuthority> grandAuthoritySet =
                user
                        .getRoles()
                        .stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                        .collect(Collectors.toUnmodifiableSet());
        return new User(
                user.getUsername(),
                user.getPassword(),
                grandAuthoritySet
                );
    }
}

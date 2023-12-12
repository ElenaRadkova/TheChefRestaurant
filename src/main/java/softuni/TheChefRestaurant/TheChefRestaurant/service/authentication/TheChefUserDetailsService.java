package softuni.TheChefRestaurant.TheChefRestaurant.service.authentication;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.RoleEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;

public class TheChefUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public TheChefUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(TheChefUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " was not found."));

    }

    private static UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(TheChefUserDetailsService::map).toList())
                .build();
    }
    private static GrantedAuthority map(RoleEntity roleEntity) {
        return new SimpleGrantedAuthority(
                "ROLE_" + roleEntity.getRole().name()
        );
    }
}

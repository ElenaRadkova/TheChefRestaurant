package softuni.TheChefRestaurant.TheChefRestaurant.service.authentication;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.RoleEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.RoleNameEnum;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class TheChefUserDetailsServiceTest {

    private TheChefUserDetailsService serviceToTest;
    private RoleEntity adminRole, userRole;
    private UserEntity testUser;

    @Mock
    private UserRepository mockUserrepository;

    @BeforeEach
    void init() {
        serviceToTest = new TheChefUserDetailsService(mockUserrepository);

        adminRole = new RoleEntity();
        adminRole.setRole(RoleNameEnum.ADMIN);

        userRole = new RoleEntity();
        userRole.setRole(RoleNameEnum.USER);

        testUser = new UserEntity();
        testUser.setUsername("elena");
        testUser.setEmail("elena@elena.com");
        testUser.setPassword("imhappy");
        testUser.setRoles(Set.of(adminRole, userRole));
    }
    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("invalid_username_not_exist")
        );
    }

    @Test
    void testUserFound() {


        Mockito
                .when(mockUserrepository.findByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        var actual = serviceToTest.loadUserByUsername(testUser.getUsername());

        Assertions.assertEquals(actual.getUsername(), testUser.getUsername());
        String actualRoles = actual
                .getAuthorities()
                .stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.joining(", "));
        String expectedRoles = "ROLE_ADMIN, ROLE_USER";
        Assertions.assertEquals(expectedRoles, actualRoles);
    }
}

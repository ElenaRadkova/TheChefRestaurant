package softuni.TheChefRestaurant.TheChefRestaurant.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.authentication.TheChefUserDetailsService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
         httpSecurity.
                authorizeHttpRequests(
                        //Define which urls are visible by which users
                        authorizeRequest -> authorizeRequest
                                //All static recourses which are situated in js, images, css are available for all
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                //Allow anyone to see the home page, register and login
                                .requestMatchers("/", "/users/register", "/users/login", "/contact-us", "/about",
                                        "individual", "cocktail", "celebrate").permitAll()
                                .requestMatchers("/user/profile").authenticated()
                                //all others are authenticated
                                .anyRequest().authenticated()
                ).formLogin(
                        formLogin -> {
                            formLogin
                                    //redirect here something which is not allowed
                                    .loginPage("/users/login")
                                    //the names of the input fields
                                    .usernameParameter("username")
                                    .passwordParameter("password")
                                    .defaultSuccessUrl("/")
                                    .failureForwardUrl("/users/login-error");
                        }
                ).logout(
                        logout -> {
                            logout
                                    .logoutUrl("/users/logout")
                                    .logoutSuccessUrl("/")
                                    .invalidateHttpSession(true);
                        }
                );
        //TODO remember me!

          return httpSecurity.build();
    }

  @Bean
  public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new TheChefUserDetailsService(userRepository);
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}


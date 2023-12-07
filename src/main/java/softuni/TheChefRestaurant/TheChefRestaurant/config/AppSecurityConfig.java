package softuni.TheChefRestaurant.TheChefRestaurant.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.impl.UserDetailsServiceImpl;


@Configuration
@EnableMethodSecurity
public class AppSecurityConfig {

//    private final OAuthSuccessHandler oAuthSuccessHandler;
//
//    private final UserDetailsServiceImpl theChefUserDetailsService;
//
//    public AppSecurityConfig(OAuthSuccessHandler oAuthSuccessHandler, UserDetailsServiceImpl theChefUserDetailsService) {
//        this.oAuthSuccessHandler = oAuthSuccessHandler;
//        this.theChefUserDetailsService = theChefUserDetailsService;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeHttpRequests(
                        //Define which urls are visible by which users
                        authorizeRequest -> authorizeRequest
                                //All static recourses which are situated in js, images, css are available for all
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                //Allow anyone to see the home page, register and login
                                .requestMatchers("/", "/users/register", "/users/login").permitAll()
                                //all others are authenticated
                                .anyRequest().authenticated()

                ).formLogin(
                        formLogin -> {
                            formLogin
                                    //redirect here something which is not allowed
                                    .loginPage("/users/login")
                                    //the names of the input fields
                                    .usernameParameter("username")
                                    .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                                    .defaultSuccessUrl("/");
//                                    .failureForwardUrl("users/login?error");
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
        return new UserDetailsServiceImpl(userRepository);
  }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
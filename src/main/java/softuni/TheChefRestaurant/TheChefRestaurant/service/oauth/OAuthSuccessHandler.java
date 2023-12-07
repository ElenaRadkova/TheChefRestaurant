package softuni.TheChefRestaurant.TheChefRestaurant.service.oauth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;


@Component
public class OAuthSuccessHandler implements AuthenticationSuccessHandler {

    private final UserService userService;


    public OAuthSuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {

        if (authentication instanceof OAuth2AuthenticationToken token) {

            OAuth2User user = token.getPrincipal();

            String username = user
                    .getAttribute("username");
            String password = user
                    .getAttribute("password");

            userService.createUserIfNotExist(username, password);
            authentication = userService.login(username);
        }

        this.onAuthenticationSuccess(request,response,authentication);
    }
}

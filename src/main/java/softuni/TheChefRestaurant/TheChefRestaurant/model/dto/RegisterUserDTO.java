package softuni.TheChefRestaurant.TheChefRestaurant.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import softuni.TheChefRestaurant.TheChefRestaurant.model.validation.FieldMatch;
import softuni.TheChefRestaurant.TheChefRestaurant.model.validation.UniqueUsername;


@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match."
)
public record RegisterUserDTO(@NotEmpty @UniqueUsername String username,
                                  @NotEmpty String fullName,
                                  @NotNull @Email String email ,
                                  String password,
                                  String confirmPassword) {

}
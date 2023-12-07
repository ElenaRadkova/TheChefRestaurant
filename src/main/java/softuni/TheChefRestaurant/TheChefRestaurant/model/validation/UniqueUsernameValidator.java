package softuni.TheChefRestaurant.TheChefRestaurant.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;


public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userRepository
                .findByUsername(username)
                .isEmpty();
    }
}

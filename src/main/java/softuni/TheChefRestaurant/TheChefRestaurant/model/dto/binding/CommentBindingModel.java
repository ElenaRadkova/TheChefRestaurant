package softuni.TheChefRestaurant.TheChefRestaurant.model.dto.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentBindingModel {
    @NotBlank
    @Size(min=10)
    private String textContent;

    public String getTextContent() {
        return textContent;
    }

    public CommentBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }
}

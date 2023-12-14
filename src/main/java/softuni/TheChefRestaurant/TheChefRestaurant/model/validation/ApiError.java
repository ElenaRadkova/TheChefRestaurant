package softuni.TheChefRestaurant.TheChefRestaurant.model.validation;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ApiError {
    private final HttpStatus status;
    private List<String> errorsField = new ArrayList<>();

    public ApiError(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void addErrorsField(String error){

    }

    public List<String> getErrorsField() {
        return errorsField;
    }

    public ApiError setErrorsField(List<String> errorsField) {
        this.errorsField = errorsField;
        return this;
    }
}


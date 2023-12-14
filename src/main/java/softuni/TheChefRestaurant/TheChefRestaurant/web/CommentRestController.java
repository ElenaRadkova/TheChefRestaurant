package softuni.TheChefRestaurant.TheChefRestaurant.web;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.binding.CommentBindingModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.CommentViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.CommentServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.validation.ApiError;
import softuni.TheChefRestaurant.TheChefRestaurant.service.CommentService;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
public class CommentRestController {
    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentRestController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/{reservationId}/comments")
        public ResponseEntity<List<CommentViewModel>> getComments(
                @PathVariable Long reservationId, Principal principal) {
          return ResponseEntity.ok(commentService.getComments(reservationId));

    }
// това което идва по REST API за нас
    @PostMapping("/api/{reservationId}/comments")
    public ResponseEntity<CommentViewModel> newComment(
            @AuthenticationPrincipal UserDetails principal,
            @PathVariable Long reservationId,
            @RequestBody @Valid CommentBindingModel commentBindingModel
    ) {
        CommentServiceModel serviceModel = modelMapper.map(commentBindingModel, CommentServiceModel.class);
        serviceModel.setReservationId(reservationId);

        CommentViewModel newComment = commentService.createNewComment(serviceModel);
        URI newCommentLocation = URI.create(String.format("/api/%s/comments/%s",reservationId, newComment.getCommentId()));  //адрерса на новия коментар

        return ResponseEntity
                .created(newCommentLocation)
                .body(newComment);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validationFailure(MethodArgumentNotValidException excep) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST); //това отива към клиента
        //всички валидации, които са в CommentBindingModel
        excep.getFieldErrors().forEach(fieldError -> apiError.addErrorsField(fieldError.getField()));

        return ResponseEntity.badRequest().body(apiError);
    }
}

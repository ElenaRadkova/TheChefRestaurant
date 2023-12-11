package softuni.TheChefRestaurant.TheChefRestaurant.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.CommentViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.service.CommentService;

import java.security.Principal;
import java.util.List;

@RestController
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/api/{reservationId}/comments")
        public ResponseEntity<List<CommentViewModel>> getComments(
                @PathVariable Long reservationId, Principal principal) {
          return ResponseEntity.ok(commentService.getComments(reservationId));

    }

}

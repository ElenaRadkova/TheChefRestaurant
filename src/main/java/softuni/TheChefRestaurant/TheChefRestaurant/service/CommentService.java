package softuni.TheChefRestaurant.TheChefRestaurant.service;

import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.CommentViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.CommentServiceModel;

import java.util.List;

public interface CommentService {
    CommentViewModel createNewComment(CommentServiceModel commentServiceModel);
    List<CommentViewModel> getComments(Long reservationId);

}

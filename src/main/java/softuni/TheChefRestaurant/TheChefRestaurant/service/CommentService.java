package softuni.TheChefRestaurant.TheChefRestaurant.service;

import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.CommentViewModel;

import java.util.List;

public interface CommentService {
    List<CommentViewModel> getComments(Long reservationId);
}

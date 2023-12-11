package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.CommentViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final ReservationRepository reservationRepository;

    public CommentServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<CommentViewModel> getComments(Long reservationId) {
        reservationRepository.findById(reservationId);
        return null;
    }
}

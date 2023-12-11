package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.exeptions.ObjectNotFoundException;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.CommentViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.CommentEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final ReservationRepository reservationRepository;

    public CommentServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<CommentViewModel> getComments(Long reservationId) {

        var reservationOpt = reservationRepository.findById(reservationId);

        if(reservationOpt.isEmpty()) {
            throw new ObjectNotFoundException("Reservation with id " + reservationId + "was not found!");
        }
        return reservationOpt
                .get()
                .getComments()
                .stream()
                .map(this::commentMap)
                .toList();
    }

    private CommentViewModel commentMap(CommentEntity commentEntity) {
        CommentViewModel commentViewModel = new CommentViewModel();
        commentViewModel
                .setCommentId(commentEntity.getId())
                .setApproved(true)
                .setDelete(true)
                .setCreated(commentEntity.getCreated())
                .setTextContent(commentEntity.getTextContent())
                .setAuthor(commentEntity.getAuthor().getFullName());

        return commentViewModel;
    }
}

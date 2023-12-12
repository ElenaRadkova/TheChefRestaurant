package softuni.TheChefRestaurant.TheChefRestaurant.service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.ReservationViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.ReservationServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.YourReservationViewModel;

import java.util.List;


public interface ReservationService {
    void addReservation(ReservationServiceModel reservationServiceModel);
    YourReservationViewModel findYourReservationById(Long id);
    List<ReservationViewModel> findAllRoutesView();
}

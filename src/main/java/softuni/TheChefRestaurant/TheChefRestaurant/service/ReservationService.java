package softuni.TheChefRestaurant.TheChefRestaurant.service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.ReservationServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.view.ReservationViewModel;


public interface ReservationService {
    void addReservation(ReservationServiceModel reservationServiceModel);

    ReservationServiceModel findYourReservationView();

    ReservationServiceModel findById();

}

package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Reservation;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.ReservationServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.view.ReservationViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.ReservationService;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;
import softuni.TheChefRestaurant.TheChefRestaurant.util.LoggedUser;



@Service
public class ReservationServiceImpl implements ReservationService {
   private final ReservationRepository reservationRepository;
   private final ModelMapper modelMapper;
   private final LoggedUser loggedUser;
   private final UserService userService;


    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;

    }

    @Override
    public void addReservation(ReservationServiceModel reservationServiceModel) {
        Reservation reservation = modelMapper.map(reservationServiceModel, Reservation.class);
        reservation.setAuthor(userService.findByUserId(loggedUser.getId()));
//        reservation.setSection(sectionService.findSectionNameEnum(reservationServiceModel.getSection()));
        reservationRepository.save(reservation);
    }

    @Override
    public ReservationServiceModel findYourReservationView() {
        return reservationRepository.findById(loggedUser.getId())
                .map(reservation -> modelMapper.map(reservation, ReservationServiceModel.class))
                .orElse(null);
    }




}

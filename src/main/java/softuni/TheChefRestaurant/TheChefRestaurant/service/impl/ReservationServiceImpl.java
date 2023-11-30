package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Reservation;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.ReservationServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.CategoryService;
import softuni.TheChefRestaurant.TheChefRestaurant.service.ReservationService;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;
import softuni.TheChefRestaurant.TheChefRestaurant.util.LoggedUser;

import java.util.stream.Collectors;


@Service
public class ReservationServiceImpl implements ReservationService {
   private final ReservationRepository reservationRepository;
   private final ModelMapper modelMapper;
   private final LoggedUser loggedUser;
   private final UserService userService;
   private final CategoryService categoryService;


    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, CategoryService categoryService) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;

        this.categoryService = categoryService;
    }

    @Override
    public void addReservation(ReservationServiceModel reservationServiceModel) {
        Reservation reservation = modelMapper.map(reservationServiceModel, Reservation.class);
        reservation.setAuthor(userService.findByUserId());
//       TODO
        reservation.setCategories(reservationServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findCategoryByName)
                .collect(Collectors.toSet()));

//        reservation.setSection(sectionService.findSectionNameEnum(reservationServiceModel.getSection()));
        reservationRepository.save(reservation);
    }
    @Override
    public ReservationServiceModel findById() {
        return reservationRepository.findById(loggedUser.getId())
                .map(reservation -> modelMapper.map(reservation, ReservationServiceModel.class))
                .orElse(null);
    }
    @Override
    public ReservationServiceModel findYourReservationView() {
        return reservationRepository.findById(loggedUser.getId())
                .map(reservation -> modelMapper.map(reservation, ReservationServiceModel.class))
                .orElse(null);
    }




}

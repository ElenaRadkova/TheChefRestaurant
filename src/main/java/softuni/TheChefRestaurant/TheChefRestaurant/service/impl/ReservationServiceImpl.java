package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.ReservationEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.ReservationServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.YourReservationViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.ReservationService;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;


@Service
public class ReservationServiceImpl implements ReservationService {
   private final ReservationRepository reservationRepository;
   private final ModelMapper modelMapper;
   private final UserService userService;



    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;

    }

    @Override
    public void addReservation(ReservationServiceModel reservationServiceModel) {
        ReservationEntity reservationEntity = modelMapper.map(reservationServiceModel, ReservationEntity.class);
//        reservationEntity.setAuthor(userService.findByUserId());
//       TODO
//        reservation.setCategories(reservationServiceModel
//                .getCategories()
//                .stream()
//                .map(categoryService::findCategoryByName)
//                .collect(Collectors.toSet()));

//        reservation.setSection(sectionService.findSectionNameEnum(reservationServiceModel.getSection()));
        reservationRepository.save(reservationEntity);
    }

    @Override
    public YourReservationViewModel findYourReservationById(Long id) {
        return reservationRepository
                .findById(id)
                .map(reservationEntity -> modelMapper.map(reservationEntity, YourReservationViewModel.class))
                .orElse(null);
    }






}

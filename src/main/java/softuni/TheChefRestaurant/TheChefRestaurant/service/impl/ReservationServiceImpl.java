package softuni.TheChefRestaurant.TheChefRestaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.ReservationViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.ReservationEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.ReservationServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.YourReservationViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.ReservationService;


import java.util.List;



@Service
public class ReservationServiceImpl implements ReservationService {
   private final ReservationRepository reservationRepository;
   private final ModelMapper modelMapper;



    public ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public void addReservation(ReservationServiceModel reservationServiceModel) {
        ReservationEntity reservationEntity = modelMapper.map(reservationServiceModel, ReservationEntity.class);
//        todo:
//        reservationEntity.setAuthor(userService.findById());

//        reservationEntity.setCategories(reservationServiceModel
//                .getCategories()
//                .stream()
//                .map(categoryService::findCategoryByName)
//                .collect(Collectors.toList()));

//        reservation.setSection(sectionService.findSectionNameEnum(reservationServiceModel.getSection()));
        reservationRepository.save(reservationEntity);
    }
    @Transactional
    @Override
    public YourReservationViewModel findYourReservationById(Long id) {
        return reservationRepository
                .findById(id)
                .map(reservationEntity -> modelMapper.map(reservationEntity, YourReservationViewModel.class))
                .orElse(null);
    }
    @Transactional
    @Override
    public List<ReservationViewModel> findAllReservationsView() {
        return  reservationRepository
                .findAll()
                .stream()
                .map(reservation -> {
                    ReservationViewModel reservationViewModel = modelMapper.map(reservation, ReservationViewModel.class);
                    if (reservation.getPictures().isEmpty()) {
                        reservationViewModel.setPictureUrl("/images/salad.jpg");
                    } else {
                        reservationViewModel.setPictureUrl(reservation.getPictures().stream().findFirst().get().getUrl());
                    }
                    return reservationViewModel;
                })
                .toList();
    }


}

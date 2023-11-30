package softuni.TheChefRestaurant.TheChefRestaurant.web;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.TheChefRestaurant.TheChefRestaurant.model.binding.AddReservationBindingModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Reservation;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.ReservationServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.service.ReservationService;
import softuni.TheChefRestaurant.TheChefRestaurant.util.LoggedUser;
import softuni.TheChefRestaurant.TheChefRestaurant.util.YourReservation;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;
    private final YourReservation yourReservation;
    private final ReservationRepository reservationRepository;


    public ReservationController(ReservationService reservationService, LoggedUser loggedUser, ModelMapper modelMapper, YourReservation yourReservation, ReservationRepository reservationRepository) {
        this.reservationService = reservationService;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.yourReservation = yourReservation;
        this.reservationRepository = reservationRepository;
    }
    @GetMapping("/your")
    public String yourReservation(Model model){

        model.addAttribute("reservation", reservationService.findYourReservationView());
        return "reservation";
    }
//    @GetMapping("/your/{id}")
//    private String your(@PathVariable Long id, Model model){
//        model.addAttribute("reservation", modelMapper
//                .map(reservationService.findById(id), ReservationViewModel.class));
//        return "reservation";
//    }


    @GetMapping("/add")
    public String add(){
       if(loggedUser.getId() == null) {
           return "redirect:/users/login";
       }
        return "add-reservation";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AddReservationBindingModel addReservationBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
          redirectAttributes.addFlashAttribute("addReservationBindingModel", addReservationBindingModel);
          redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addReservationBindingModel", bindingResult);
          return "redirect:add";
        }
//        Reservation reservation = modelMapper.map(reservationService, Reservation.class);
////       за да запишем нашия модел в базата трябва да го закачим за сървис
//       reservationService.addReservation(modelMapper.map(addReservationBindingModel, ReservationServiceModel.class));
////       reservationService.findYourReservationView();
        ReservationServiceModel reservationServiceModel = modelMapper.map(addReservationBindingModel, ReservationServiceModel.class);
        reservationService.addReservation(reservationServiceModel);

        return "redirect:/reservations/your";
    }

    @ModelAttribute
    public AddReservationBindingModel addReservationBindingModel(){
        return new AddReservationBindingModel();
    }


}

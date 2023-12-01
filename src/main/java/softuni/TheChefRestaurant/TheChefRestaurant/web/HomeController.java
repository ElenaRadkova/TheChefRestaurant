package softuni.TheChefRestaurant.TheChefRestaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.TheChefRestaurant.TheChefRestaurant.service.PictureService;
import softuni.TheChefRestaurant.TheChefRestaurant.service.ReservationService;
import softuni.TheChefRestaurant.TheChefRestaurant.util.LoggedUser;

@Controller
public class HomeController {

    private final PictureService pictureService;
    private final LoggedUser loggedUser;
    private final ReservationService reservationService;

    public HomeController(PictureService pictureService, LoggedUser loggedUser, ReservationService reservationService) {
        this.pictureService = pictureService;
        this.loggedUser = loggedUser;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String index(Model model){
        if (loggedUser.getId() == null) {
            return "home";
        }
//        model.addAttribute("reservations", reservationService.findAllYourReservation());
        model.addAttribute("pictures", pictureService.findAllUrls());

        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }


}

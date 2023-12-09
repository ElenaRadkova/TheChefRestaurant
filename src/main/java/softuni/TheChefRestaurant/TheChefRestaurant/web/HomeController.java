package softuni.TheChefRestaurant.TheChefRestaurant.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.TheChefRestaurant.TheChefRestaurant.service.PictureService;
import softuni.TheChefRestaurant.TheChefRestaurant.service.ReservationService;

@Controller
public class HomeController {

    private final PictureService pictureService;
    private final ReservationService reservationService;

    public HomeController(PictureService pictureService, ReservationService reservationService) {
        this.pictureService = pictureService;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String home(Model model){
//        model.addAttribute("reservations", reservationService.findAllYourReservation());
        model.addAttribute("pictures", pictureService.findAllUrls());

        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/contact-us")
    public String contactUs() {
        return "contact-us";
    }
    @GetMapping("/individual")
    public String individual() {
        return "individual";
    }
    @GetMapping("/cocktail")
    public String cocktail() {
        return "cocktail";
    }
    @GetMapping("/celebrate")
    public String celebrate() {
        return "celebrate";
    }


}

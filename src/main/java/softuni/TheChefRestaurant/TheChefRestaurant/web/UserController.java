package softuni.TheChefRestaurant.TheChefRestaurant.web;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.binding.UserLoginBindingModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.binding.UserRegisterBindingModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.service.UserServiceModel;
import softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view.UserViewModel;
import softuni.TheChefRestaurant.TheChefRestaurant.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;

    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }
    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                                                                              bindingResult);
            return "redirect:register";
        }

       //TODO existing username with custom...
        return "redirect:login";
    }
//

//    @GetMapping("/login")
//    public String login(Model model){
//        model.addAttribute("isExist", true);
//        return "login";
//    }
//    @PostMapping("/login")
//    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
//                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            redirectAttributes
//                    .addFlashAttribute("userLoginBindingModel",userLoginBindingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
//                            bindingResult);
//            return "redirect:/users/login";
//        }
//
//        return "redirect:/";
//    }

    @GetMapping("/profile/{id}")
    private String profile(@PathVariable Long id, Model model){
        model.addAttribute("user", modelMapper
                             .map(userService.findById(id), UserViewModel.class));
           return "profile";
    }


}


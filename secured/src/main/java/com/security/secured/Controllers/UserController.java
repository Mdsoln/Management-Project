package com.security.secured.Controllers;

import com.security.secured.Entity.Form;
import com.security.secured.Entity.User;
import com.security.secured.Repositories.UserRepo;
import com.security.secured.Services.UserServiceImpl;
import com.security.secured.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
     private UserServiceImpl userService;
    @GetMapping("/index")
    public String defaultPage(){
        return "index";
    }
    @GetMapping({"/", "/landing"})
    public String indexPage() {
        return "landing";
    }
    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }
    @GetMapping("/community")
    public String communityPage(){
        return "community";
    }
    @GetMapping("/cv")
    public String myCV(Model model){
        model.addAttribute("form",new Form());
        return "cv";
    }
    @GetMapping("/register")
    public String registerPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result,Model model){
        User userExists = userService.findByUserEmail(userDto.getEmail());
        if (userExists != null && userExists.getEmail() != null && !userExists.getEmail().isEmpty()){
            result.reject("email",null,"There exist user with email: "+userExists.getEmail());
        }
        if(result.hasErrors()){
            model.addAttribute("user",userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    /*url for cv details*/
    @PostMapping("/cv/save")
    public String formCv(@Valid @ModelAttribute("form") Form form,BindingResult result,Model model){
       String username = getUserEmail();
       form.setName(username);
       userService.saveOpinions(form);
       if (result.hasErrors()){
           model.addAttribute("form",form);
           return "cv";
       }
       return "redirect:/cv?success";
    }

    private String getUserEmail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()){
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        else {
            return principal.toString();
        }
    }
}

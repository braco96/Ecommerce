package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.LoginService;
import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.infrastructure.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @GetMapping("/access")
    public String access(RedirectAttributes attributes, HttpSession httpSession){
        User user = loginService.getUser( Integer.parseInt( httpSession.getAttribute("iduser").toString() ) ) ;
        attributes.addFlashAttribute("id", httpSession.getAttribute("iduser").toString() );
        if(loginService.existUser(user.getEmail())){
           if (loginService.getUserType(user.getEmail()).name().equals("ADMIN")){
               return "redirect:/admin";
           }else{
               return "redirect:/home";
           }
        }
        return "redirect:/home";
    }

}

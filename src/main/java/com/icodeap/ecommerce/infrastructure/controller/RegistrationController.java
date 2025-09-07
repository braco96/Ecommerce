package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.RegistrationService;
import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.domain.UserType;
import com.icodeap.ecommerce.infrastructure.dto.UserDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String register(UserDto userDto){
        return "register";
    }
    @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        user.setDateCreated(LocalDateTime.now());
//        user.setUserType(UserType.USER);
//        user.setUsername(user.getEmail());

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(
                    e->{ log.info( "Error {}", e.getDefaultMessage() ); }
            );
            return "register";
        }
        registrationService.register(userDto.userDtoToUser());
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/register";
    }

}

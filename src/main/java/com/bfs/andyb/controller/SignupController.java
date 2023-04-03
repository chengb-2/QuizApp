package com.bfs.andyb.controller;

import com.bfs.andyb.domain.User;
import com.bfs.andyb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class SignupController {
    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getSignup(HttpServletRequest request, Model model) {
        return "signup";
    }

    // validate that we are always getting a new session after login
    @PostMapping("/signup")
    public String postSignup(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String firstname,
                             @RequestParam String lastname,
                             @RequestParam String phone,
                             @RequestParam String address,
                             @RequestParam String email,
                             Model model,
                             HttpServletRequest request) {


        Optional<User> possibleUser = userService.getUserByUsername(username);

        if(possibleUser.isPresent()) {
            model.addAttribute("prompt", "User already exists, please use a different username!");
            return "signup";
        } else { // if user details are invalid
            userService.createNewUser(username, password, firstname, lastname, phone, address, email);
            System.out.println("User created!");
            return "login";
        }

//        Optional<User> possibleUser = userService.getUserByUsername(username);
//
//
//        int changedRowCount = userService.createNewUser(username, password, firstname, lastname, phone, address, email);
//
//        if(changedRowCount == 0) {
//            System.out.println("User already exist!");
//            return "signup";
//        } else { // if user details are invalid
//            System.out.println("User created!");
//            return "login";
//        }
    }
}

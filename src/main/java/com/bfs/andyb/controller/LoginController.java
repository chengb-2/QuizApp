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
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            return "redirect:/home";
        }

//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);

        return "login";
    }

    // validate that we are always getting a new session after login
    @PostMapping("/login")
    public String postLogin(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request,
                            Model model) {
        Optional<User> possibleUser = userService.validateLogin(username, password);

        if(possibleUser.isPresent()) {
            if (!possibleUser.get().getIs_active()) return "redirect:/suspended";

            HttpSession oldSession = request.getSession(false);
            // invalidate old session if it exists
            if (oldSession != null) oldSession.invalidate();

            // generate new session
            HttpSession newSession = request.getSession(true);

            // store user details in session
            newSession.setAttribute("user", possibleUser.get());

            if (possibleUser.get().getIs_admin()) return "redirect:/admin";
            return "redirect:/home";
        } else { // if user details are invalid
            return "redirect:/login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession oldSession = request.getSession(false);
        // invalidate old session if it exists
        if(oldSession != null) oldSession.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/suspended")
    public String getSuspended(HttpServletRequest request, Model model) {
        return "suspended";
    }
}

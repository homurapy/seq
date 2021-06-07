package com.example.seq.controller;


import com.example.seq.model.User;
import com.example.seq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class DaoController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "Welcome";
    }

    @GetMapping("/scope/inc")
    public void incUserScope(Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
    userService.addUserScore(user,1);
    }
    @GetMapping("/scope/dec")
    public void decUserScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
        userService.addUserScore(user,-1);
    }
    @GetMapping("/score/get/current")

    public Integer currentUserScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
        return user.getScore();
    }
    @GetMapping("/score/get/{id} ")
    public Integer findScoreByUserId(@PathVariable Long id){
        return userService.findById(id).getScore();
    }


}

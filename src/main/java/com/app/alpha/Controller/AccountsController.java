package com.app.alpha.Controller;

import com.app.alpha.Repository.AccountsRepository;
import com.app.alpha.Utilities.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/")
public class AccountsController {
    @Autowired
    AccountsRepository repo;

    @Autowired
    SecurityConfig securityConfig;

    @GetMapping("/all")
    public Object getall(){
        return repo.findAll();
    }


    @GetMapping("/box-auth")
    public String loginbox(){
        return "hienthi";
    }
}

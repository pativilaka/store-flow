package com.fiap.store_flow.controllers;


import com.fiap.store_flow.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    //Todo: Autenticação
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getMe(){
        return null;
    }
}

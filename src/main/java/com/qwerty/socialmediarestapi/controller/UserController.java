package com.qwerty.socialmediarestapi.controller;

import com.qwerty.socialmediarestapi.auth.AuthenticationRequest;
import com.qwerty.socialmediarestapi.auth.AuthenticationResponse;
import com.qwerty.socialmediarestapi.auth.AuthenticationService;
import com.qwerty.socialmediarestapi.auth.RegisterRequest;
import com.qwerty.socialmediarestapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }



}

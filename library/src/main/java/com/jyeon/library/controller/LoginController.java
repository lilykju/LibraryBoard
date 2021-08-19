package com.jyeon.library.controller;

import com.jyeon.library.dto.LoginDto;
import com.jyeon.library.dto.TokenDto;
import com.jyeon.library.dto.UserDto;
import com.jyeon.library.jwt.JwtTokenProvider;
import com.jyeon.library.model.User;
import com.jyeon.library.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody @NotNull LoginDto loginDto) {

       // HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("Authorization", "Bearer " + jwt);
        return ResponseEntity.ok(userService.login(loginDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

}

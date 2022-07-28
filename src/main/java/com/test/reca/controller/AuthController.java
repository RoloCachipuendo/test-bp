package com.test.reca.controller;

import com.test.reca.config.JWTUtil;
import com.test.reca.model.dto.AuthenticationRequest;
import com.test.reca.model.dto.AuthenticationResponse;
import com.test.reca.service.TestUserDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@Api(tags = "Autenticación de usuario")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TestUserDetailService testUserDetailService;

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            UserDetails userDetails= testUserDetailService.loadUserByUsername(request.getUsername());
            String jwt=jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt),HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }

}

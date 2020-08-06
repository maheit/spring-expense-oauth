package com.maheit.expense.controllers;

import com.maheit.expense.config.JwtToken;
import com.maheit.expense.model.JwtRequest;
import com.maheit.expense.model.JwtResponse;
import com.maheit.expense.service.JwtUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    // @RequestMapping(value = "/auth", method = RequestMethod.POST)
    // public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

    //     authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    //     final UserDetails userDetails = jwtUserDetailService.loadUserByUsername("root");

    //     final String token = jwtToken.generateToken(userDetails);
    //     return ResponseEntity.ok(new JwtResponse(token));
    //     // return new SomeData();
    // }

    // @GetMapping("/authentication")
    // public ResponseEntity<?> authenticateGet(@RequestParam(value = "name", defaultValue = "mahesh") String name)
    //         throws Exception {

    //     authenticate("root", "password");
    //     final UserDetails userDetails = jwtUserDetailService.loadUserByUsername("root");

    //     final String token = jwtToken.generateToken(userDetails);
    //     return ResponseEntity.ok(new JwtResponse(token));
    //     // return new SomeData();
    // }

    private void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
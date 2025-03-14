package com.XGroup.PrepX.Backend.Controller;

import com.XGroup.PrepX.Backend.Models.UserModel;
import com.XGroup.PrepX.Backend.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin("http://localhost:5173/")
@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/signup")
    public ResponseEntity<String> CreateNewUser(@RequestBody UserModel newUser) {
        try {
            boolean check = userServices.CreateNewUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserModel newUser) {
        try {
            String token = userServices.checkUser(newUser);

            if (token != null) {
                // Return the JWT token in the response
                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("username", newUser.getUsername());

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication error: " + e.getMessage());
        }
    }

}

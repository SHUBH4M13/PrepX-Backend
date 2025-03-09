package com.XGroup.PrepX.Backend.Controller;

import com.XGroup.PrepX.Backend.Models.UserModel;
import com.XGroup.PrepX.Backend.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:5173/")
@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/signup")
    public  ResponseEntity<String> CreateNewUser(@RequestBody UserModel newUser ){
        try {
            boolean check = userServices.CreateNewUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<String> LoginUser(@RequestBody UserModel newUser ){
            boolean check = userServices.CheckUser(newUser);
            if(check){
                return ResponseEntity.status(HttpStatus.OK).body("User Found");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
            }
    }
}
//dsadasdsa

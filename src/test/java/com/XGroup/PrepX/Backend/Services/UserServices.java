package com.XGroup.PrepX.Backend.Services;

import com.XGroup.PrepX.Backend.Models.UserModel;
import com.XGroup.PrepX.Backend.Repo.UserRepo;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private  UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    public boolean CreateNewUser(UserModel newUser ){
        try {
            Optional<UserModel> UserExist = userRepo.findByEmail(newUser.getEmail());
            if( UserExist.isPresent() ){
                throw new RuntimeException("User Already Exist");
            }
            newUser.setPassword(encoder.encode(newUser.getPassword()));
            userRepo.save(newUser);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserModel> getalluser(){
        return userRepo.findAll();
    }

    public String checkUser(UserModel newUser) {
        try {
            UserModel userExist = userRepo.findByUsername(newUser.getUsername());
            if (userExist != null) {
                Authentication auth = authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(newUser.getUsername(), newUser.getPassword())
                );

                if (auth.isAuthenticated()) {
                    return jwtService.generateToken(newUser.getUsername());
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

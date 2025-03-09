package com.XGroup.PrepX.Backend.Services;

import com.XGroup.PrepX.Backend.Models.UserModel;
import com.XGroup.PrepX.Backend.Repo.UserRepo;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private  UserRepo userRepo;

    public boolean CreateNewUser(UserModel newUser ){
        try {
            Optional<UserModel> UserExist = userRepo.findByEmail(newUser.getEmail());
            if( UserExist.isPresent() ){
                throw new RuntimeException("User Already Exist");
            }
            userRepo.save(newUser);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean CheckUser(UserModel newUser ){
        try {
            Optional<UserModel> UserExist = userRepo.findByUsername(newUser.getUsername());
            if( UserExist.isPresent() ){
                if(newUser.getPassword().equals(UserExist.get().getPassword())){
                    return true;
                }
            }
            else  {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}

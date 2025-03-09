package com.XGroup.PrepX.Backend.Repo;

import com.XGroup.PrepX.Backend.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<UserModel , String > {
    Optional<UserModel> findByEmail(String email );
    Optional<UserModel> findByUsername(String username );
}

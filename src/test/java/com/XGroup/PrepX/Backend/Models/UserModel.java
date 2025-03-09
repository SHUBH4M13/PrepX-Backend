package com.XGroup.PrepX.Backend.Models;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    public @NonNull String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public @NonNull String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @Field("username")
    @NonNull
    @Indexed( unique = true )
    private String username;

    @Field("email")
    @NonNull
    @Indexed( unique = true )
    private String email;

    @Field("password")
    @NonNull
    private String password;

}

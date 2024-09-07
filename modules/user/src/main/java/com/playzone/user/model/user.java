package com.playzone.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
@Data
public class user {

    private UUID id;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;

}

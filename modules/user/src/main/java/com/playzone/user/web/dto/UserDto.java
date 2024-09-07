package com.playzone.user.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {

    @NoArgsConstructor
    @Data
    public class user {

        private String email;
        private String phone;
        private String firstName;
        private String lastName;

    }

}

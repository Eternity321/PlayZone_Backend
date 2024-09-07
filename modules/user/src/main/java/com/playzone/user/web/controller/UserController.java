package com.playzone.user.web.controller;

import com.playzone.user.model.user;
import com.playzone.user.web.dto.UserDto;
import com.playzone.user.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserMapper userMapper;

    @PostMapping("/create")
    public void create(@RequestBody UserDto dto) {
        user user = userMapper.toEntity(dto);
    }

}

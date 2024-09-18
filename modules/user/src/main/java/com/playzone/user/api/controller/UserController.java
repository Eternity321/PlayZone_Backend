package com.playzone.user.api.controller;

import com.playzone.user.api.dto.request.UserRequest;
import com.playzone.user.model.User;
import com.playzone.user.api.mapper.UserMapper;
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
    public void create(@RequestBody UserRequest dto) {
        User user = userMapper.toEntity(dto);
    }

}

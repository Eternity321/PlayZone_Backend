package com.playzone.user.web.mapper;

import com.playzone.user.model.user;
import com.playzone.user.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<user, UserDto> {
}

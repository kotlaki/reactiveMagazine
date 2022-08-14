package ru.kurganov.mapper;

import org.modelmapper.PropertyMap;
import ru.kurganov.domain.Users;
import ru.kurganov.domain.dto.UserDto;

public class UserDto2UserMapper extends PropertyMap<UserDto, Users> {

    @Override
    protected void configure() {
        map(source.getEmail(), destination.getEmail());
        map(source.getLastName(), destination.getLastName());
        map(source.getFirstName(), destination.getLastName());
        map(source.getMiddleName(), destination.getMiddleName());
        map(source.getPhone(), destination.getPhone());
        map(source.getCreateDate(), destination.getCreateDate());
        map(source.isActive(), destination.isActive());
    }
}

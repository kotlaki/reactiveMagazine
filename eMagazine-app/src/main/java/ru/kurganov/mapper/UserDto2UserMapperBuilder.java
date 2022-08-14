package ru.kurganov.mapper;

import org.modelmapper.ModelMapper;

public class UserDto2UserMapperBuilder implements ModelMapperBuilder{

    @Override
    public void onInit(ModelMapper mapper) {
        mapper.addMappings(new UserDto2UserMapper());
    }
}

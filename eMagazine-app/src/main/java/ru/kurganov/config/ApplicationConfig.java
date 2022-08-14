package ru.kurganov.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kurganov.mapper.UserDto2UserMapperBuilder;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UserDto2UserMapperBuilder userDto2UserMapperBuilder() {
        return new UserDto2UserMapperBuilder();
    }

}

package ru.kurganov.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperBuilder {
    void onInit(ModelMapper mapper);
}

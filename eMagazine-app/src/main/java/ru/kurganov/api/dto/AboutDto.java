package ru.kurganov.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Информация о приложении
 *
 * @author Kurganov Roman
 **/
@Getter
@Setter
@Builder
@ApiModel(description = "Информация о версии БД")
public class AboutDto {
    /**
     * Версия БД
     */
    @ApiModelProperty("Версия БД")
    private String releaseVersionDataBase;
}

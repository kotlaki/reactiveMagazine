package ru.kurganov.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kurganov.api.dto.AboutDto;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_OK;

/**
 * Описание API для получения информации о версии БД приложения
 *
 * @author Roman Kurganov
 **/

@Api(value = "about")
public interface AboutApi {
    @ApiOperation(value = "Получение информации о версии БД приложения",
                  response = AboutDto.class, tags = {"about",})
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Информация о БД приложения",
                         response = AboutDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Внутренняя ошибка обработки запроса",
                         response = String.class)})
    @RequestMapping(value = "/about",
                    produces = APPLICATION_JSON,
                    method = RequestMethod.GET)
    ResponseEntity<AboutDto> getAboutPage(Model model);
}

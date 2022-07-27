package ru.kurganov.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kurganov.api.AboutApi;
import ru.kurganov.api.dto.AboutDto;

@RestController
@Api(tags = "about")
@RequestMapping({"/api/rest/"})
public class AboutController implements AboutApi {

    private final AboutDto about;

    public AboutController(@Value("@{eMagazine.db.version}") String about) {
        this.about = AboutDto.builder().releaseVersionDataBase(about).build();
    }

    public ResponseEntity<AboutDto> getAboutPage(Model model) {
        return ResponseEntity.ok(about);
    }
}

package ru.kurganov.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.validation.constraints.NotNull;

@ConfigurationProperties(
        prefix = "emagazine.app"
)
@Data
public class AppProperties {
    private @NotNull String version;
}

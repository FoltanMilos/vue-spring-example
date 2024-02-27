package sk.itmf.customspringbackend.weather.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("weather.api")
public class WeatherConfiguration {

    private String url;

    private String key;
}

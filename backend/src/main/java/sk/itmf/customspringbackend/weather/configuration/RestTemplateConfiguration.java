package sk.itmf.customspringbackend.weather.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean("weatherRestTemplate")
    public RestTemplate weatherRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}

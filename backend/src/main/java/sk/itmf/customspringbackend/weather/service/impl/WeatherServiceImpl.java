package sk.itmf.customspringbackend.weather.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.itmf.customspringbackend.weather.config.WeatherConfiguration;
import sk.itmf.customspringbackend.weather.dto.WeatherAggregatedRecord;
import sk.itmf.customspringbackend.weather.service.WeatherService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    
    private final RestTemplate weatherRestTemplate;
    private final WeatherConfiguration weatherConfiguration;
     
    @Override
    public Optional<WeatherAggregatedRecord> getActualWeatherInfo(double lon, double lat) {
        return Optional.ofNullable(
                weatherRestTemplate.getForEntity(weatherConfiguration.getUrl(),
                WeatherAggregatedRecord.class, lon, lat, weatherConfiguration.getKey()).getBody());
    }
}

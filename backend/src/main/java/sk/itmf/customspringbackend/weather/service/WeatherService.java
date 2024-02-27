package sk.itmf.customspringbackend.weather.service;

import sk.itmf.customspringbackend.weather.dto.WeatherAggregatedRecord;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherAggregatedRecord> getActualWeatherInfo(double lon, double lat);
}

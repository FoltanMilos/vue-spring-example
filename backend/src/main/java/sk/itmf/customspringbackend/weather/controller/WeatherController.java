package sk.itmf.customspringbackend.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.itmf.customspringbackend.weather.dto.WeatherAggregatedRecord;
import sk.itmf.customspringbackend.weather.service.WeatherService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static sk.itmf.customspringbackend.weather.enumeration.SupportedLocations.*;

@RequestMapping(value = "/api/weather", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Time series successfully obtained")
    })
    @Operation(summary = "Gets time series for weather")
    @GetMapping(value = "/all")
    public List<WeatherAggregatedRecord> getAllWeatherTimeSeries() {
        //testing purposes :)
        return Stream.of(
                weatherService.getActualWeatherInfo(ZILINA.getLongitude(), ZILINA.getLatitude()).orElse(null),
                weatherService.getActualWeatherInfo(BRATISLAVA.getLongitude(), BRATISLAVA.getLatitude()).orElse(null),
                weatherService.getActualWeatherInfo(BRNO.getLongitude(), BRNO.getLatitude()).orElse(null)
        ).filter(Objects::nonNull).collect(Collectors.toList());
    }
}

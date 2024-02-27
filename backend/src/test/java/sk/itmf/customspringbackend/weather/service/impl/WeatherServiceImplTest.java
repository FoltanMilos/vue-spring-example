package sk.itmf.customspringbackend.weather.service.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sk.itmf.customspringbackend.weather.configuration.WeatherConfiguration;
import sk.itmf.customspringbackend.weather.dto.*;
import sk.itmf.customspringbackend.weather.enumeration.SupportedLocations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {

    @InjectMocks
    private WeatherServiceImpl instance;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WeatherConfiguration weatherConfiguration;

    @Nested
    class getActualWeatherInfo {

        @Test
        public void wheatherActualInfo_noResult() {
            when(weatherConfiguration.getUrl()).thenReturn("http://localhost");
            when(weatherConfiguration.getKey()).thenReturn("key");
            when(restTemplate.getForEntity(weatherConfiguration.getUrl(),
                    WeatherAggregatedRecord.class, SupportedLocations.ZILINA.getLongitude(),
                    SupportedLocations.ZILINA.getLatitude(), weatherConfiguration.getKey())).thenReturn(
                    ResponseEntity.ok(null)
            );

            Optional<WeatherAggregatedRecord> optionalWeatherAggregatedRecord = instance.getActualWeatherInfo(
                    SupportedLocations.ZILINA.getLongitude(),
                    SupportedLocations.ZILINA.getLatitude()
            );

            assertTrue(optionalWeatherAggregatedRecord.isEmpty());
        }

        @Test
        public void wheatherActualInfo_foundResult() {
            when(weatherConfiguration.getUrl()).thenReturn("http://localhost");
            when(weatherConfiguration.getKey()).thenReturn("key");
            when(restTemplate.getForEntity(weatherConfiguration.getUrl(),
                    WeatherAggregatedRecord.class, SupportedLocations.ZILINA.getLongitude(),
                    SupportedLocations.ZILINA.getLatitude(), weatherConfiguration.getKey())).thenReturn(
                    ResponseEntity.ok(createWeatherAggregatedRecord())
            );

            Optional<WeatherAggregatedRecord> optionalWeatherAggregatedRecord = instance.getActualWeatherInfo(
                    SupportedLocations.ZILINA.getLongitude(),
                    SupportedLocations.ZILINA.getLatitude()
            );

            assertTrue(optionalWeatherAggregatedRecord.isPresent());
        }

        private WeatherAggregatedRecord createWeatherAggregatedRecord() {
            return new WeatherAggregatedRecord(
                    new CoordRecord(SupportedLocations.ZILINA.getLongitude(), SupportedLocations.ZILINA.getLatitude()),
                    new WeatherRecord[]{new WeatherRecord(1, "main", "description", "icon")},
                    "base",
                    new MainRecord(0.0, 0.0, 0.0, 0.0, 1L, 0),
                    0L,
                    new WindRecord(0.0, 1),
                    new CloudRecord(0),
                    1L,
                    new SysRecord(2, 1L, "country", 1L, 1L),
                    1L,
                    1L,
                    "name",
                    200
            );
        }
    }


}
package sk.itmf.customspringbackend.weather.dto;

public record MainRecord(double temp, double feels_like, double temp_min, double temp_max, long pressure, int humidity) {
}

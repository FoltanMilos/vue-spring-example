package sk.itmf.customspringbackend.weather.dto;

public record SysRecord(int type, long id, String country, long sunrise, long sunset) {
}

package sk.itmf.customspringbackend.weather.dto;

public record WeatherAggregatedRecord(
        CoordRecord coord,
        WeatherRecord[] weather,
        String base,
        MainRecord main,
        long visibility,
        WindRecord wind,
        CloudRecord clouds,
        long dt,
        SysRecord sys,
        long timeZone, long id, String name, int cod) {
}



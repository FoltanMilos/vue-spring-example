package sk.itmf.customspringbackend.weather.enumeration;

import lombok.Getter;

@Getter
public enum SupportedLocations {

    ZILINA(49.22315, 18.73941),
    BRATISLAVA(48.148598, 17.107748),
    BRNO(49.195061, 16.606836);

    private final double longitude;
    private final double latitude;

    SupportedLocations(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

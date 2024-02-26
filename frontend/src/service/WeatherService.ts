import http from "@/http-common";

class WeatherService {
    getWeatherDataAll(): Promise<any> {
        return http.get("/weather/all");
    }
}

export default new WeatherService();
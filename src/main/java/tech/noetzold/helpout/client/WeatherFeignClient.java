package tech.noetzold.helpout.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.noetzold.helpout.model.WeatherResponse;

@FeignClient(name = "weather-api", url = "https://api.openweathermap.org/data/2.5")
public interface WeatherFeignClient {

    @GetMapping("/weather")
    WeatherResponse getWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("appid") String apiKey);
}

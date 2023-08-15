package tech.noetzold.helpout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.helpout.client.WeatherFeignClient;
import tech.noetzold.helpout.model.WeatherResponse;

@Service
public class WeatherPredictService {
    private final WeatherFeignClient weatherFeignClient;

    @Autowired
    public WeatherPredictService(WeatherFeignClient weatherFeignClient) {
        this.weatherFeignClient = weatherFeignClient;
    }

    public WeatherResponse getWeather(String lat, String lon, String apiKey) {
        return weatherFeignClient.getWeather(lat, lon, apiKey);
    }
}

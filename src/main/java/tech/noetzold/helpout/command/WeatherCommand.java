package tech.noetzold.helpout.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import tech.noetzold.helpout.model.WeatherResponse;
import tech.noetzold.helpout.service.WeatherPredictService;

import java.math.BigDecimal;

@ShellComponent
public class WeatherCommand {
    private final WeatherPredictService weatherService;

    @Autowired
    public WeatherCommand(WeatherPredictService weatherService) {
        this.weatherService = weatherService;
    }

    @ShellMethod("Get weather forecast for a city.")
    public String weather() {
        String lat = "-28.2612";
        String lon = "-52.4083";
        String appid = "1472b7ec49efc4bf9eabbdb1026f3cea";
        WeatherResponse weatherResponse = weatherService.getWeather(lat, lon, appid);
        weatherResponse = convertKelvin(weatherResponse);
        return weatherResponse.getMain().toString();
    }

    public WeatherResponse convertKelvin(WeatherResponse weatherResponse){
        weatherResponse.getMain().setTemp(weatherResponse.getMain().getTemp().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setTemp_max(weatherResponse.getMain().getTemp_max().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setTemp_min(weatherResponse.getMain().getTemp_min().subtract(new BigDecimal("273.15")));
        weatherResponse.getMain().setFeels_like(weatherResponse.getMain().getFeels_like().subtract(new BigDecimal("273.15")));

        return weatherResponse;
    }
}

package tech.noetzold.helpout.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import tech.noetzold.helpout.model.WeatherResponse;
import tech.noetzold.helpout.service.WeatherPredictService;

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

        return weatherResponse.getMain().toString();
    }
}

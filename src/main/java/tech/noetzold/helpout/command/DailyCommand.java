package tech.noetzold.helpout.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import tech.noetzold.helpout.service.DolarService;
import tech.noetzold.helpout.service.NewsService;
import tech.noetzold.helpout.service.WeatherPredictService;

@ShellComponent
public class DailyCommand {

    private final DolarService dolarService;
    private final NewsService newsService;
    private final WeatherPredictService weatherService;

    @Autowired
    public DailyCommand(DolarService dolarService, NewsService newsService, WeatherPredictService weatherService) {
        this.dolarService = dolarService;
        this.newsService = newsService;
        this.weatherService = weatherService;
    }

    @ShellMethod("Daily command")
    public String daily(){
        String weather = new WeatherCommand(weatherService).weather();
        String news = new NewsCommand(newsService).news();
        String dolar = new DolarCommand(dolarService).dolar();

        return dolar +"\n" +
                weather + "\n " +
                news +"\n";
    }


}

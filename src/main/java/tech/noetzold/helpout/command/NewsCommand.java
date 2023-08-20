package tech.noetzold.helpout.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import tech.noetzold.helpout.service.NewsService;

@ShellComponent
public class NewsCommand {

    private final NewsService newsService;

    @Autowired
    public NewsCommand(NewsService newsService) {
        this.newsService = newsService;
    }

    @ShellMethod("Show the news")
    public String news() {
        System.out.print("Obtendo notícias   ");
        animateLoading();

        String news = newsService.getNews();

        return "\nNoticicias: " + news + " R$";
    }

    private void animateLoading() {
        String[] animationFrames = {"|", "/", "-", "\\"};
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.print("\b" + animationFrames[i % animationFrames.length]);
                System.out.flush();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

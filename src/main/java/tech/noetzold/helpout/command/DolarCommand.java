package tech.noetzold.helpout.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import tech.noetzold.helpout.service.DolarService;

import java.math.BigDecimal;

@ShellComponent
public class DolarCommand {
    private final DolarService dolarService;

    @Autowired
    public DolarCommand(DolarService dolarService) {
        this.dolarService = dolarService;
    }

    @ShellMethod("Mostra a cotação atual do dólar em reais.")
    public String dolar() {
        System.out.print("Obtendo cotação do dólar   ");
        animateLoading();

        BigDecimal dolarRate = dolarService.getDolarRate();
        String formattedDolarRate = String.format("%.2f", dolarRate);

        return "\nCotação do dólar: " + formattedDolarRate + " R$";
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
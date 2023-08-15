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
    public void dolar() {
        BigDecimal dolarRate = dolarService.getDolarRate();
        System.out.println("Cotação do dólar: " + dolarRate.toString());
    }
}
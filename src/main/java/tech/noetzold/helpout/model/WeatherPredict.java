package tech.noetzold.helpout.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WeatherPredict {

    private BigDecimal temp;
    private BigDecimal feels_like;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private int pressure;
    private int humidity;
    private int sea_level;
    private int grnd_level;


    @Override
    public String toString() {
        return "Temperatura de " + temp + " sensação térmica de " + feels_like + " humidade. Temperatura mínima de " + temp_min + " e máxima de " + temp_max;
    }
}

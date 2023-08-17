package tech.noetzold.helpout.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class WeatherResponse {

    WeatherPredict main;
}

package tech.noetzold.helpout.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DolarValue {
    private String code;
    private String codein;
    private String name;
    private BigDecimal high;
    private BigDecimal low;
    @JsonProperty("varBid")
    private BigDecimal variationBid;
    @JsonProperty("pctChange")
    private BigDecimal percentChange;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal timestamp;
    @JsonProperty("create_date")
    private String createDate;

}

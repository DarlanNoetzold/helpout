package tech.noetzold.helpout.model;


import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DolarResponse {

    @JsonProperty("USDBRL")
    private DolarValue USDBRL;
}

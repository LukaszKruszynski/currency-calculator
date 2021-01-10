package pl.kruszynski.currencycalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
@JsonFormat
public class Currency {
    @JsonProperty
    public String currency;
    @JsonProperty
    public String code;
    @JsonProperty
    public BigDecimal mid;
}

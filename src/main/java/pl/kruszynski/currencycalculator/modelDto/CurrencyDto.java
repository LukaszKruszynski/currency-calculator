package pl.kruszynski.currencycalculator.modelDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
@JsonFormat
public class CurrencyDto {
    @JsonProperty
    private String currency;
    @JsonProperty
    private String code;
    @JsonProperty
    private BigDecimal mid;
}

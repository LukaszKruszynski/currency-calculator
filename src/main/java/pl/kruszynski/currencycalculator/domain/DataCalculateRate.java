package pl.kruszynski.currencycalculator.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@JsonFormat
public class DataCalculateRate {
    @JsonProperty
    private BigDecimal amount;
    @JsonProperty
    private String currencyAmountCode;
    @JsonProperty
    private String currencyAmountCodeToCalculate;
}

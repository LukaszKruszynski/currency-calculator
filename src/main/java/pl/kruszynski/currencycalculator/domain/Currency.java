package pl.kruszynski.currencycalculator.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Currency {
    private String currency;
    private String code;
    private BigDecimal mid;
}

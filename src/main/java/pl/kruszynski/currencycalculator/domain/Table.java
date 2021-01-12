package pl.kruszynski.currencycalculator.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Table {
    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<Currency> rates;
}

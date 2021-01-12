package pl.kruszynski.currencycalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Table {
    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<Currency> rates;
}

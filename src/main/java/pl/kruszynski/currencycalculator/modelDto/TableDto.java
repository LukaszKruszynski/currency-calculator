package pl.kruszynski.currencycalculator.modelDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@JsonFormat
public class TableDto {
    @JsonProperty
    private String table;
    @JsonProperty
    private String no;
    @JsonProperty
    private LocalDate effectiveDate;
    @JsonProperty
    private List<CurrencyDto> rates;
}

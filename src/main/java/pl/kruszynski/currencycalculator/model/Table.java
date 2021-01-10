package pl.kruszynski.currencycalculator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
@JsonFormat
public class Table {
    @JsonProperty
    public String table;
    @JsonProperty
    public String no;
    @JsonProperty
    public LocalDate effectiveDate;
    @JsonProperty
    public Currency rates;
}

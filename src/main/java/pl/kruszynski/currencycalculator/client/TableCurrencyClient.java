package pl.kruszynski.currencycalculator.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.kruszynski.currencycalculator.domain.Table;
import pl.kruszynski.currencycalculator.mapper.TableMapper;
import pl.kruszynski.currencycalculator.modelDto.TableDto;
import pl.kruszynski.currencycalculator.modelDto.TableType;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TableCurrencyClient {

    private static final String JSON_FORMAT = "?format=json";
    private static final String API_URL = "http://api.nbp.pl/api/exchangerates/tables/";
    private final TableMapper tableMapper;
    private final RestTemplate restTemplate;


    private URI uriBuilder(TableType tableType) {
        return URI.create(API_URL + tableType + JSON_FORMAT);
    }

    @GetMapping
    public Table fetchRates(TableType tableType) {
        TableDto[] rates;
        try {
            rates = restTemplate.getForObject(uriBuilder(tableType), TableDto[].class);
        } catch (RestClientException e) {
            return new Table(new ArrayList<>());
        }
        Optional<TableDto> optional = Arrays.stream(rates).findAny();
        Table table = new Table();
        if (optional.isPresent()) {
            table = tableMapper.mapToTable(optional.get());
        }
        return table;
    }
}


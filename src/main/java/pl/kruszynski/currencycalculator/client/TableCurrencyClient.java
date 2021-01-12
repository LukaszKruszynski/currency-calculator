package pl.kruszynski.currencycalculator.client;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import pl.kruszynski.currencycalculator.domain.Table;
import pl.kruszynski.currencycalculator.mapper.TableMapper;
import pl.kruszynski.currencycalculator.modelDto.TableDto;
import pl.kruszynski.currencycalculator.modelDto.TableType;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static pl.kruszynski.currencycalculator.configuration.Config.restTemplate;

@RestController
public class TableCurrencyClient {

    final String JSON_FORMAT = "?format=json";
    private TableMapper tableMapper;

    @Autowired
    public TableCurrencyClient(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }

    private URI uriBuilder(TableType tableType) {
        return URI.create("http://api.nbp.pl/api/exchangerates/tables/" + tableType + JSON_FORMAT);
    }

    @GetMapping
    public Table fetchRates(TableType tableType) {
        TableDto[] response = restTemplate().getForObject(uriBuilder(tableType), TableDto[].class);
        Optional<TableDto> optional = Arrays.stream(response).findAny();
        try {
            return tableMapper.mapToTable(optional.get());
        } catch (RestClientException e) {
            return new Table(new ArrayList<>());
        }
    }
}

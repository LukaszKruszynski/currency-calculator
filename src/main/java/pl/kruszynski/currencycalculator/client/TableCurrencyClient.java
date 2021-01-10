package pl.kruszynski.currencycalculator.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kruszynski.currencycalculator.model.Table;
import pl.kruszynski.currencycalculator.model.TableType;

import java.net.URI;

import static pl.kruszynski.currencycalculator.configuration.Config.restTemplate;

@RestController
public class TableCurrencyClient {

    private URI uriBuilder(TableType tableType) {
        return URI.create("http://api.nbp.pl/api/exchangerates/tables/" + tableType + "?format=json");
    }

    @GetMapping
    public Table getRates(TableType tableType) {
        return restTemplate().getForObject(uriBuilder(tableType) ,Table.class);
    }

}

package pl.kruszynski.currencycalculator.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kruszynski.currencycalculator.client.TableCurrencyClient;
import pl.kruszynski.currencycalculator.model.Table;
import pl.kruszynski.currencycalculator.model.TableType;

@Service
public class TableCurrencyService {

    @Autowired
    TableCurrencyClient client;


    public Table getRates(TableType tableType) {
       return client.getRates(tableType);
    }
}

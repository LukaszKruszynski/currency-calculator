package pl.kruszynski.currencycalculator.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kruszynski.currencycalculator.service.client.TableCurrencyService;

import java.math.BigDecimal;

@SpringBootTest
class TableDtoCurrencyDtoClientTest {

    @Autowired
    TableCurrencyService tableCurrencyService;
    @Test
    void test() {
        BigDecimal result = tableCurrencyService.CalculateRates(BigDecimal.valueOf(5), "usd", "eur");
        System.out.println(result);
    }
}
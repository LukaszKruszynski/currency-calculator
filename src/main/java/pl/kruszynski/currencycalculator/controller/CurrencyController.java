package pl.kruszynski.currencycalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kruszynski.currencycalculator.domain.DataCalculateRate;
import pl.kruszynski.currencycalculator.service.TableCurrencyService;

import java.math.BigDecimal;

@RestController
public class CurrencyController {

    private final TableCurrencyService tableCurrencyService;

    @Autowired
    public CurrencyController(TableCurrencyService tableCurrencyService) {
        this.tableCurrencyService = tableCurrencyService;
    }
    @PostMapping("/calculate")
    public BigDecimal fetchCalculateRates(@RequestBody DataCalculateRate dataCalculateRate) {
        return tableCurrencyService.CalculateRates(dataCalculateRate);
    }
}

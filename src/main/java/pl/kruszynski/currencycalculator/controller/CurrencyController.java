package pl.kruszynski.currencycalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kruszynski.currencycalculator.domain.DataCalculateRate;
import pl.kruszynski.currencycalculator.service.TableCurrencyService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final TableCurrencyService tableCurrencyService;

    @PostMapping("/calculate")
    public BigDecimal fetchCalculateRates(@RequestBody DataCalculateRate dataCalculateRate) {
        return tableCurrencyService.calculateRates(dataCalculateRate);
    }
}

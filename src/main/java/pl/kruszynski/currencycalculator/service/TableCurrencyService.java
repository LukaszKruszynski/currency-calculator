package pl.kruszynski.currencycalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kruszynski.currencycalculator.client.TableCurrencyClient;
import pl.kruszynski.currencycalculator.domain.Currency;
import pl.kruszynski.currencycalculator.domain.DataCalculateRate;
import pl.kruszynski.currencycalculator.domain.Table;
import pl.kruszynski.currencycalculator.modelDto.TableType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TableCurrencyService {
    private TableCurrencyClient client;
    private Map<Currency, BigDecimal> currencies;

    @Autowired
    public TableCurrencyService(TableCurrencyClient client) {
        this.client = client;

    }

    public Table getTableTypeRates(TableType tableType) {
        return client.fetchRates(tableType);
    }

    private List<Currency> fetchTableAAndBRates() {
        Table tableA = this.getTableTypeRates(TableType.A);
        Table tableB = this.getTableTypeRates(TableType.B);
        List<Currency> allTableTypeRates = new ArrayList<>();
        allTableTypeRates.addAll(tableA.getRates());
        allTableTypeRates.addAll(tableB.getRates());
        return allTableTypeRates;
    }

    public void fillCurrencies() {
        currencies = this.fetchTableAAndBRates().stream()
                .collect(Collectors.toMap(e -> e, Currency::getMid));
    }

    public BigDecimal calculateRates(DataCalculateRate dataCalculateRate) {
        BigDecimal currencyValue = this.findCurrencyValue(dataCalculateRate.getCurrencyAmountCode());
        BigDecimal currencyValueToCalculate = this.findCurrencyValue(dataCalculateRate.getCurrencyAmountCodeToCalculate());
        BigDecimal toPLN = calculateToPLN(dataCalculateRate.getAmount(), currencyValue);
        return toPLN.divide(currencyValueToCalculate, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateToPLN(BigDecimal amount, BigDecimal currencyValue) {
        return amount.multiply(currencyValue);
    }

    public BigDecimal findCurrencyValue(String currencyAmountCode) {
        List<BigDecimal> currencyAmountValueList = this.getCurrencies().entrySet().stream()
                .filter(e -> e.getKey().getCode().equals(currencyAmountCode.toUpperCase()))
                .map(e -> e.getKey().getMid())
                .collect(Collectors.toList());
        return currencyAmountValueList.stream().findFirst().orElse((BigDecimal.ZERO));
    }

    public Map<Currency, BigDecimal> getCurrencies() {
        return currencies;
    }
}
package pl.kruszynski.currencycalculator.service.client;

import lombok.Getter;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.kruszynski.currencycalculator.client.TableCurrencyClient;
import pl.kruszynski.currencycalculator.domain.Currency;
import pl.kruszynski.currencycalculator.domain.Table;
import pl.kruszynski.currencycalculator.modelDto.TableType;

import java.math.BigDecimal;
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
        return client.getRates(tableType);
    }

    private List<Currency> getAllRates() {
        Table tableA = this.getTableTypeRates(TableType.A);
        Table tableB = this.getTableTypeRates(TableType.B);
        List<Currency> allTableTypeRates = new ArrayList<>();
        allTableTypeRates.addAll(tableA.getRates());
        allTableTypeRates.addAll(tableB.getRates());
        return allTableTypeRates;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "0 0 8 * * *")
    private void fetchCurrencies() {
        Map<Currency, BigDecimal> currencies = this.getAllRates().stream()
                .collect(Collectors.toMap(e -> e, Currency::getMid));
        this.currencies = currencies;
    }


    public void CalculateRates(BigDecimal amount, String currencyAmountCode, String currencyAmountCodeToCalculate) {
        BigDecimal currencyValue;
        BigDecimal currencyValueToCalculate;
        List<BigDecimal> currencyAmountValueList = this.getCurrencies().entrySet().stream()
                .filter(e -> e.getKey().getCode().equals(currencyAmountCode))
                .map(e -> e.getKey().getMid())
                .collect(Collectors.toList());
        List<BigDecimal> currencyAmountValueToCalculateList = this.getCurrencies().entrySet().stream()
                .filter(e -> e.getKey().getCode().equals(currencyAmountCodeToCalculate))
                .map(e -> e.getKey().getMid())
                .collect(Collectors.toList());
        if (currencyAmountValueList.size() > 0) {
        }
        if (currencyAmountValueToCalculateList.size() > 0) {
            currencyValueToCalculate = currencyAmountValueToCalculateList.get(0);
        }

    }

    public Map<Currency, BigDecimal> getCurrencies() {
        return currencies;
    }
}
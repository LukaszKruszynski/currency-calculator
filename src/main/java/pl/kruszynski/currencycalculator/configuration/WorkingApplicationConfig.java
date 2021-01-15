package pl.kruszynski.currencycalculator.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import pl.kruszynski.currencycalculator.service.TableCurrencyService;

@RequiredArgsConstructor
public class WorkingApplicationConfig {
    private final TableCurrencyService tableCurrencyService;

    @Scheduled(cron = "0 0 8 * * *")
    public void fetchNewCurrenciesData() {
        tableCurrencyService.fillCurrencies();
    }
}

package pl.kruszynski.currencycalculator.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kruszynski.currencycalculator.service.TableCurrencyService;

@Component
@RequiredArgsConstructor
public class StartApplicationConfig {

    private final TableCurrencyService tableCurrencyService;

    @EventListener(ApplicationReadyEvent.class)
    private void prepareCurrenciesData() {
        tableCurrencyService.fillCurrencies();
    }

}

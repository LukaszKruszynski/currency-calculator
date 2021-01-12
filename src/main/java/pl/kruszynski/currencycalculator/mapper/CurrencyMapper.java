package pl.kruszynski.currencycalculator.mapper;

import org.springframework.stereotype.Component;
import pl.kruszynski.currencycalculator.domain.Currency;
import pl.kruszynski.currencycalculator.modelDto.CurrencyDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyMapper {
    public Currency mapToCurrency(CurrencyDto currencyDto) {
        return Currency.builder()
                .currency(currencyDto.getCurrency())
                .mid(currencyDto.getMid())
                .code(currencyDto.getCode())
                .build();
    }
    public List<Currency> mapToCurrency(List<CurrencyDto> currencies) {
       return currencies.stream()
                .map(this::mapToCurrency)
                .collect(Collectors.toList());
    }
}

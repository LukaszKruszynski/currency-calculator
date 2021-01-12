package pl.kruszynski.currencycalculator.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kruszynski.currencycalculator.domain.Table;
import pl.kruszynski.currencycalculator.modelDto.TableDto;

@Component
public class TableMapper {

    private CurrencyMapper currencyMapper;

    @Autowired
    public TableMapper(CurrencyMapper currencyMapper) {
        this.currencyMapper = currencyMapper;
    }

    public Table mapToTable (TableDto tableDto) {
        return Table.builder()
                .table(tableDto.getTable())
                .no(tableDto.getNo())
                .effectiveDate(tableDto.getEffectiveDate())
                .rates(currencyMapper.mapToCurrency(tableDto.getRates()))
                .build();
    }
}

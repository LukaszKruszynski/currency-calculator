package pl.kruszynski.currencycalculator.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.kruszynski.currencycalculator.domain.Table;
import pl.kruszynski.currencycalculator.mapper.TableMapper;
import pl.kruszynski.currencycalculator.modelDto.TableDto;
import pl.kruszynski.currencycalculator.modelDto.TableType;

@RestController
@RequiredArgsConstructor
public class TableCurrencyClient {

	private static final String JSON_FORMAT = "?format=json";
	private static final String API_URL = "http://api.nbp.pl/api/exchangerates/tables/";

	private final TableMapper tableMapper;
	private final RestTemplate restTemplate;

	private URI uriBuilder(TableType tableType) {
		return URI.create(new StringBuilder().append(API_URL).append(tableType).append(JSON_FORMAT).toString());
	}

	@GetMapping
	public Table fetchRates(TableType tableType) {
		TableDto[] response = restTemplate.getForObject(uriBuilder(tableType), TableDto[].class);
		Optional<TableDto> optional = Arrays.stream(response).findAny();
		try {
			Table table = new Table();
			if (optional.isPresent()) {
				table = tableMapper.mapToTable(optional.get());
			}
			return table;
		} catch (RestClientException e) {
			return new Table(new ArrayList<>());
		}
	}
}

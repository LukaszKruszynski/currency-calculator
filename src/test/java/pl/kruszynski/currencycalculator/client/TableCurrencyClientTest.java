package pl.kruszynski.currencycalculator.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
import org.springframework.boot.test.autoconfigure.web.client.WebClientRestTemplateAutoConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import pl.kruszynski.currencycalculator.model.Table;
import reactor.core.publisher.Flux;

class TableCurrencyClientTest {
    TableCurrencyClient tableCurrencyClient = new TableCurrencyClient();

    @Test
    void test() {
//        tableCurrencyClient.getRates(TableType.A);
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/B/?format=json", Table.class);
//        restTemplate.execute("http://api.nbp.pl/api/exchangerates/tables/B/?format=json", HttpMethod.GET);
//        WebClient webClient = WebClient.create();
//        Flux<Table> tableFlux = webClient.get()
//                .uri("http://api.nbp.pl/api/exchangerates/tables/B/?format=json")
//                .retrieve()
//                .bodyToFlux()


    }
}
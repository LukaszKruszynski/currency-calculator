package pl.kruszynski.currencycalculator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class Config {

    @Bean
    public static RestTemplate restTemplate () {
        return new RestTemplate();
    }
    @Bean
    public static String nbpUrl() {
        return "http://api.nbp.pl/api/exchangerates/tables/";
    }
}

package pl.kruszynski.currencycalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrencyCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyCalculatorApplication.class, args);
    }
}

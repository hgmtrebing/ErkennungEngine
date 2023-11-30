package com.erkennung.erkennungapi.german;

import com.erkennung.deutsch.grammar.Articles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GermanConfiguration {

    @Bean
    public Articles getArticles() {
        return new Articles();
    }
}

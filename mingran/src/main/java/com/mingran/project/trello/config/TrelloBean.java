package com.mingran.project.trello.config;

import com.julienvey.trello.Trello;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aircjm
 */
@Configuration
public class TrelloBean {

    @Value("${trello.token}")
    private String token;

    @Value("${trello.apiKey}")
    private String apiKey;


    @Bean
    public Trello getTrelloApi() {
        return new TrelloImpl(token, apiKey, new ApacheHttpClient());
    }


}

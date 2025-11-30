package com.workshop.springAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.springAI.dto.CurrencyDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/currency")
@Log4j2
@RequiredArgsConstructor
public class CurrencyController {
    private final ChatClient chatClient;

    @GetMapping("/find-curr-exchange-rate")
    public CurrencyDetails findCurrencyExchangeRate(@RequestParam String country) {

        var system = """
                1. You are a currency bot.
                2. You will be given a country name and you need to find the currency of that country.
                3. You need to find today's USD exchange rate for the currency and the as on date for this rate.
                4. If you cannot find the currency or the exchange rate for the given country, you need to return "Currency and exchange rate not found for the given country" in the notFoundMessage object of the record.
                """;

        return chatClient.prompt()
                .user(c -> {
                    c.text("Find the currency and exchange rate for the country: {country}");
                    c.param("country", country);
                })
                .system(system)
                .call()
                .entity(CurrencyDetails.class);
    }

}

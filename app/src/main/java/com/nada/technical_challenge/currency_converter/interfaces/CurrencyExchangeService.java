package com.nada.technical_challenge.currency_converter.interfaces;

import com.nada.technical_challenge.currency_converter.exchange.CurrencyExchange;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyExchangeService {
    @GET("latest?base=EUR&access_key=84655e6a421370727bc9e29bd80771bb")
    Call<CurrencyExchange> loadCurrencyExchange();
}

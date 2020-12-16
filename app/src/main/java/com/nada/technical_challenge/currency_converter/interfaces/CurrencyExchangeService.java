package com.nada.technical_challenge.currency_converter.interfaces;

import com.nada.technical_challenge.currency_converter.exchange.CurrencyExchange;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyExchangeService {
    @GET("latest")
    Call<CurrencyExchange> loadCurrencyExchange();
}

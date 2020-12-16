package com.nada.technical_challenge.currency_converter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nada.technical_challenge.R;
import com.nada.technical_challenge.currency_converter.adapter.CurrencyAdapter;
import com.nada.technical_challenge.currency_converter.exchange.CurrencyExchange;
import com.nada.technical_challenge.currency_converter.interfaces.CurrencyExchangeService;
import com.nada.technical_challenge.currency_converter.interfaces.CurrencyItemClickListener;
import com.nada.technical_challenge.currency_converter.model.Currency;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyConverterActivity extends AppCompatActivity implements Callback<CurrencyExchange>, CurrencyItemClickListener {

    private ListView lvCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        lvCurrency = (ListView) findViewById(R.id.lvCurrency);

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadCurrencyExchangeData();
    }

    private void loadCurrencyExchangeData(){
        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.fixer.io/")
//                .baseUrl("https://data.fixer.io/api/")
//                .baseUrl("https://data.fixer.io/api/latest?access_key=84655e6a421370727bc9e29bd80771bb")
                .baseUrl("https://data.fixer.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CurrencyExchangeService service = retrofit.create(CurrencyExchangeService.class);
        Call<CurrencyExchange> call = service.loadCurrencyExchange();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<CurrencyExchange> call, Response<CurrencyExchange> response) {
        //Toast.makeText(this, response.body().getBase(), Toast.LENGTH_LONG).show();
        CurrencyExchange currencyExchange = response.body();
        lvCurrency.setAdapter(new CurrencyAdapter(this, currencyExchange.getCurrencyList(), this));
    }

    @Override
    public void onFailure(Call<CurrencyExchange> call, Throwable t) {
        System.out.println("\n" + "\n");
        System.out.println("---------------------");
        System.out.println("\n" + "\n");
        System.out.println("\n" + t + "\n");
        System.out.println("\n" + "\n");
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
        System.out.println("\n" + t + "\n");
        System.out.println("---------------------");
    }

    @Override
    public void onCurrencyItemClick(Currency c) {
        //Toast.makeText(this, c.getName(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("currency_name", c.getName());
        intent.putExtra("currency_rate", c.getRate());

        startActivity(intent);
    }

}

package com.reto.api.service;

import com.reto.api.model.Currency;
import com.reto.api.model.Exchange;
import io.reactivex.Single;

import java.util.List;

public interface CurrencyService {
    Single<List<Currency>> findAllCurrency();
    Single<Currency> registerCurrency(Currency request);
    Single<Exchange> registerChange(Exchange request);
    Single<List<Currency>> updateCurrency(List<Currency> request);
}

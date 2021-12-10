package com.reto.api.service;

import com.reto.api.model.Currency;
import com.reto.api.model.Exchange;
import com.reto.api.repository.ExchangeRepository;
import com.reto.api.repository.CurrencyRepository;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public Single<List<Currency>> findAllCurrency() {
        return Single.create(subscriber -> {
            subscriber.onSuccess(currencyRepository.findAll());
        });
    }

    @Override
    public Single<Currency> registerCurrency(Currency request) {
        return Single.create(subscriber -> {
            subscriber.onSuccess(currencyRepository.save(request));
        });
    }

    @Override
    public Single<Exchange> registerChange(Exchange request) {
        return Single.create(subscriber -> {
            Currency currency = currencyRepository.findByOriginCurrencyAndDestinyCurrency(request.getOriginCurrency(), request.getDestinyCurrency());

            Double amountDestiny = request.getOriginAmount() * currency.getCurrencyExchange();

            request.setExchangeRate(currency.getCurrencyExchange());
            request.setDestinyAmount(amountDestiny);

            subscriber.onSuccess(exchangeRepository.save(request));
        });
    }

    @Override
    public Single<List<Currency>> updateCurrency(List<Currency> request) {
        return Single.create(subscriber -> {
            try {
                List<Currency> lstFromH2 = currencyRepository.findAll();
                for(Currency currencyH2 : lstFromH2) {
                    for (Currency currencyRequest : request) {
                        if (currencyRequest.getOriginCurrency().equals(currencyH2.getOriginCurrency())
                                && currencyRequest.getDestinyCurrency().equals(currencyH2.getDestinyCurrency())){
                            Currency currencyGarbage = new Currency();
                            currencyGarbage.setId(currencyH2.getId());
                            currencyGarbage.setOriginCurrency(currencyH2.getOriginCurrency());
                            currencyGarbage.setDestinyCurrency(currencyH2.getDestinyCurrency());
                            currencyGarbage.setCurrencyExchange(currencyRequest.getCurrencyExchange());
                            currencyRepository.save(currencyGarbage);
                        } else {
                            currencyRepository.save(currencyRequest);
                        }
                    }
                }
                subscriber.onSuccess(currencyRepository.findAll());
            } catch (Throwable e) {
                subscriber.onError(e);
            }
        });
    }
}

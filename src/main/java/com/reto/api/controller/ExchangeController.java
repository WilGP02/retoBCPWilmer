package com.reto.api.controller;

import java.util.List;

import com.reto.api.model.Currency;
import com.reto.api.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reto.api.service.CurrencyService;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("reto/api")
public class ExchangeController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency")
    public Single<ResponseEntity<List<Currency>>> findAllCurrency() {
        return currencyService.findAllCurrency()
                .subscribeOn(Schedulers.io())
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK));
    }

    @PostMapping("/currency")
    public Single<ResponseEntity<Currency>> registerCurrency(@RequestBody Currency request) {
        return currencyService.registerCurrency(request)
                .subscribeOn(Schedulers.io())
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK));
    }

    @PostMapping("/updateCurrency")
    public Single<ResponseEntity<List<Currency>>> updateCurrency(@RequestBody List<Currency> request) {
        return currencyService.updateCurrency(request)
                .subscribeOn(Schedulers.io())
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK));
    }

    @PostMapping(value = "/change", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Single<ResponseEntity<Exchange>> registerChange(@RequestBody Exchange request) {
        return currencyService.registerChange(request)
                .subscribeOn(Schedulers.io())
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK));
    }

}

package com.reto.api.repository;

import com.reto.api.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByOriginCurrencyAndDestinyCurrency(String originCurrency, String destinyCurrency);
}

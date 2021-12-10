package com.reto.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ORIGINCURRENCY")
    private String originCurrency;

	@Column(name = "DESTINYCURRENCY")
    private String destinyCurrency;

	@Column(name = "CURRENCYEXCHANGE")
    private Double currencyExchange;

}

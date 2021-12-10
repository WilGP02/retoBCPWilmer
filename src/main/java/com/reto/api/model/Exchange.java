package com.reto.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "exchange")
public class Exchange {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double originAmount;

    @Column
    private Double destinyAmount;

    @Column
    private String originCurrency;

    @Column
    private String destinyCurrency;

    @Column
    private Double exchangeRate;
    
}

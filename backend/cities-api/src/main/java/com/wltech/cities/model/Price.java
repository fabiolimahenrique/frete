package com.wltech.cities.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "preco")
public class Price {

    @Id
    private Long id;

    private Long faixa1;

    private Long faixa2;

    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFaixa1() {
        return faixa1;
    }

    public void setFaixa1(Long faixa1) {
        this.faixa1 = faixa1;
    }

    public Long getFaixa2() {
        return faixa2;
    }

    public void setFaixa2(Long faixa2) {
        this.faixa2 = faixa2;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

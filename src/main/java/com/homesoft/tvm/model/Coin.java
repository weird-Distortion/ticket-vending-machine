package com.homesoft.tvm.model;

import java.math.BigDecimal;

public class Coin {

    private BigDecimal coinValue;

    public Coin() {
        super();
    }

    public BigDecimal getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(BigDecimal coinValue) {
        this.coinValue = coinValue;
    }
}

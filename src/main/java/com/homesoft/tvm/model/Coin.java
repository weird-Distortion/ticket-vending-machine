package com.homesoft.tvm.model;

import java.math.BigDecimal;

public class Coin {

    private BigDecimal coinValue;

    public Coin(String coinValue) {
        this.coinValue = new BigDecimal(coinValue);
    }

    public BigDecimal getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(BigDecimal coinValue) {
        this.coinValue = coinValue;
    }

}

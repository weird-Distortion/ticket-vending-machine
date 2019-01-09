package com.homesoft.tvm.model;

import java.math.BigDecimal;

public class Coin {

    private BigDecimal coinValue;
//    private String cv;

    public Coin(String coinValue) {
        this.coinValue = new BigDecimal(coinValue);
//        cv = coinValue;
    }

    public BigDecimal getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(BigDecimal coinValue) {
        this.coinValue = coinValue;
    }

//    public String getCv() {
//        return cv;
//    }
//
//    public void setCv(String cv) {
//        this.cv = cv;
//    }
}

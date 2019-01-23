package com.homesoft.tvm.model;

import java.math.BigDecimal;

public class Coin extends OutputObject implements CoinInterface {

    public Coin(String objType, String objCost) {
        super(objType, objCost);
    }

    @Override
    public BigDecimal getCoinCost() {
        return getObjCost();
    }

    @Override
    public String getCoinType() {
        return getObjType();
    }
}

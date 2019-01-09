package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public class ChangeKeeper implements Keeper {

    private Map<Coin, Integer> map;

    public ChangeKeeper() {
        this.map = new HashMap<>();
    }

    @Override
    public void giveOut(String type) {

    }

    @Override
    public Map<Coin, Integer> getMap() {
        return map;
    }
}

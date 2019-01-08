package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public class ChangeKeeper implements Keeper {

    private Map<Coin, Integer> map;

    public ChangeKeeper() {
        this.map = new HashMap<>();
    }

    @Override
    public void addToKeeper(Object key, Integer value) {
        assert map != null : "map is Null";
        assert key != null : "key is Null";
        map.putIfAbsent((Coin)key, value);
    }

    @Override
    public void giveOut(String type) {

    }

    @Override
    public Map<Coin, Integer> getMap() {
        return map;
    }
}

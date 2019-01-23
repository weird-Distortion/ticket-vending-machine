package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public class ChangeKeeper extends Keeper implements ChangeKeeping {

    private Map<String, Integer> map;

    public ChangeKeeper() {
        this.map = new HashMap<>();
    }

    @Override
    public void addToKeeper(String key, Integer value) {
        putCoinsToKeeper(key, value);
    }

    @Override
    public String giveOut(String type) {
        return giveOutOneCoin(type);
    }

    @Override
    public Map<String, Integer> getMap() {
        return getCoinMap();
    }

    private void putCoinsToKeeper(String key, Integer value) {
        map.putIfAbsent(key, value);
    }

    private String giveOutOneCoin(String coinType) {
        if (isEnoughCoins(coinType)) {
            map.computeIfPresent(coinType, (k, v) -> v - 1);
            return coinType;
        }

        return "-1";
    }

    private boolean isEnoughCoins(String type) {
        return map.get(type) > 0;
    }

    private Map<String, Integer> getCoinMap() {
        return this.map;
    }
}

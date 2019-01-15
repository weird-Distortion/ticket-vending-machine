package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public class ChangeKeeper implements Keeper {

    private Map<String, Integer> map;

    public ChangeKeeper() {
        this.map = new HashMap<>();
    }

    @Override
    public String giveOut(String type) {
        if (isPositive(type)) {
            map.computeIfPresent(type, (k, v) -> v - 1);
            return type;
        }

        return "-1";
    }

    @Override
    public Map<String, Integer> getMap() {
        return map;
    }

    private boolean isPositive(String type) {
        return map.get(type) > 0;
    }
}

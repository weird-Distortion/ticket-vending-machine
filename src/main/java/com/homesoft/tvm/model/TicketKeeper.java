package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public class TicketKeeper implements Keeper{

    private Map<String, Integer> map;

    public TicketKeeper() {
        this.map = new HashMap<>();
    }

    @Override
    public void addToKeeper(Object key, Integer value) {
        assert map != null : "map is Null";
        assert key != null : "key is Null";
        map.putIfAbsent((String)key, value);
    }

    @Override
    public void giveOut(String type) {
        map.computeIfPresent(type, (k, v) -> v - 1);
    }

    @Override
    public Map<String, Integer> getMap() {
        return map;
    }
}

package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractKeeper<T> {

    private Map<T, Integer> map;

    public AbstractKeeper() {
        this.map = new HashMap<>();
    }

    public Map<T, Integer> getMap() {
        return map;
    }

    public void addToKeeper(T key, Integer value) {

        assert map != null : "Map is null";
        assert key != null : "New Key is null";
        map.put(key, value);
    }
}

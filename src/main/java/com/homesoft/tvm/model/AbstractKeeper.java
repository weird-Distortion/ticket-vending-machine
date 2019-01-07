package com.homesoft.tvm.model;

import java.util.Map;

public abstract class AbstractKeeper {

    private Map<?, Integer> map;

    public AbstractKeeper(Map<?, Integer> map) {
        this.map = map;
    }

    public Map<?, Integer> getMap() {
        return map;
    }
}

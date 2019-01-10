package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public class ChangeKeeper implements Keeper {

    private Map<String, Integer> map;

    public ChangeKeeper() {
        this.map = new HashMap<>();
    }

    @Override
    public void giveOut(String type) {

    }

    @Override
    public Map<String, Integer> getMap() {
        return map;
    }
}

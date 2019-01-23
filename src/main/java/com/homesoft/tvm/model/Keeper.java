package com.homesoft.tvm.model;

import java.util.Map;

public abstract class Keeper {
    public abstract void addToKeeper(String key, Integer value);
    public abstract String giveOut(String type);
    public abstract Map<String, Integer> getMap();
}

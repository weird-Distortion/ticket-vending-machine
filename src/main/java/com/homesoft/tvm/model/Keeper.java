package com.homesoft.tvm.model;

import java.util.Map;

public interface Keeper<T> {
    void addToKeeper(T key, Integer value);
    void giveOut(String type);
    Map<T, Integer> getMap();
}

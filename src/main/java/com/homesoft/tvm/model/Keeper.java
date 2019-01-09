package com.homesoft.tvm.model;

import java.util.Map;

public interface Keeper<T> {

    default void addToKeeper(Map<T, Integer> map, T key, Integer value) {
        assert map != null : "map is Null";
        assert key != null : "key is Null";
        map.putIfAbsent(key, value);
    }

    void giveOut(String type);
    Map<T, Integer> getMap();
}

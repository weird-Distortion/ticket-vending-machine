package com.homesoft.tvm.model;

import java.util.Map;

public interface Keeper {

    default void addToKeeper(Map<String, Integer> map, String key, Integer value) {
        assert map != null : "map is Null";
        assert key != null : "key is Null";
        map.putIfAbsent(key, value);
    }

    String giveOut(String type);
    Map<String, Integer> getMap();
}

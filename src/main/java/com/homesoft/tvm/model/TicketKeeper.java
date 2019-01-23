package com.homesoft.tvm.model;

import java.util.HashMap;
import java.util.Map;

public class TicketKeeper extends Keeper implements TicketsKeeping {

    private Map<String, Integer> map;

    public TicketKeeper() {
        this.map = new HashMap<>();
    }

    @Override
    public void addToKeeper(String key, Integer value) {
        putTicketsToKeeper(key, value);
    }

    @Override
    public String giveOut(String ticketType) {
        return giveOutOneTicket(ticketType);
    }

    @Override
    public Map<String, Integer> getMap() {
        return getTicketsMap();
    }

    private void putTicketsToKeeper(String key, Integer value) {
        map.putIfAbsent(key, value);
    }

    private String giveOutOneTicket(String ticketType) {
        if (isEnoughTickets(ticketType)) {
            map.computeIfPresent(ticketType, (k, v) -> v - 1);
            return ticketType;
        }

        return "-1";
    }

    private boolean isEnoughTickets(String type) {
        return map.get(type) > 0;
    }

    private Map<String, Integer> getTicketsMap() {
        return this.map;
    }
}

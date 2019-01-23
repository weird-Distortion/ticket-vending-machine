package com.homesoft.tvm.model;

import java.math.BigDecimal;

public class Ticket extends OutputObject implements TicketInterface {

    public Ticket(String objType, String objCost) {
        super(objType, objCost);
    }

    @Override
    public BigDecimal getTicketCost() {
        return getObjCost();
    }

    @Override
    public String getTicketType() {
        return getObjType();
    }
}

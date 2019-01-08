package com.homesoft.tvm.model;

import java.math.BigDecimal;

public class Ticket {

    private String type;
    private BigDecimal ticketCost;

    public Ticket(String type, String ticketCost) {
        this.type = type;
        this.ticketCost = new BigDecimal(ticketCost);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(BigDecimal ticketCost) {
        this.ticketCost = ticketCost;
    }
}

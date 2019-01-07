package com.homesoft.tvm.model;

import java.util.HashMap;

public class Machine {

    private AbstractKeeper ticketKeeper;
    private AbstractKeeper changeKeeper;

    public Machine() {
        this.ticketKeeper = new TicketKeeper(new HashMap<>());
        this.changeKeeper = new ChangeKeeper(new HashMap<>());
    }

    public AbstractKeeper getTicketKeeper() {
        return ticketKeeper;
    }

    public void setTicketKeeper(AbstractKeeper ticketKeeper) {
        this.ticketKeeper = ticketKeeper;
    }

    public AbstractKeeper getChangeKeeper() {
        return changeKeeper;
    }

    public void setChangeKeeper(AbstractKeeper changeKeeper) {
        this.changeKeeper = changeKeeper;
    }
}

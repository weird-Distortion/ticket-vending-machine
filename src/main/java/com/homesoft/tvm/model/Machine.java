package com.homesoft.tvm.model;

public class Machine {

    private AbstractKeeper ticketKeeper;
    private AbstractKeeper changeKeeper;

    public Machine() {
        this.ticketKeeper = new TicketKeeper();
        this.changeKeeper = new ChangeKeeper();
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

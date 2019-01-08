package com.homesoft.tvm.model;

public class Machine {

    private Keeper ticketKeeper;
    private Keeper changeKeeper;

    public Machine() {
        this.ticketKeeper = new TicketKeeper();
        this.changeKeeper = new ChangeKeeper();
    }

    public Keeper getTicketKeeper() {
        return ticketKeeper;
    }

    public void setTicketKeeper(Keeper ticketKeeper) {
        this.ticketKeeper = ticketKeeper;
    }

    public Keeper getChangeKeeper() {
        return changeKeeper;
    }

    public void setChangeKeeper(Keeper changeKeeper) {
        this.changeKeeper = changeKeeper;
    }
}

package com.homesoft.tvm.model;

public class Machine {

    private Keeper ticketKeeper;
    private Keeper changeKeeper;
    private UserInput userInput;

    public Machine() {
        this.ticketKeeper = new TicketKeeper();
        this.changeKeeper = new ChangeKeeper();
        this.userInput = new UserInput();
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

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}

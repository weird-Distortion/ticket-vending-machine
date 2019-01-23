package com.homesoft.tvm.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Machine {

    private List<Keeper> keepers;
    private UserInput userInput;

    public Machine() {
        this.keepers = new ArrayList<>(asList(new TicketKeeper(), new ChangeKeeper()));
        this.userInput = new UserInput();
    }

    public List<Keeper> getAllKeepers() {
        return keepers;
    }

//    public Keeper getTicketKeeper() {
//        return getTicketKeepers().stream().findFirst().get();
//    }
//
//    public Keeper getChangeKeeper() {
//        return getChangeKeepers().stream().findFirst().get();
//    }

    public List<Keeper> getChangeKeepers() {
        return this.keepers
                .stream()
                .filter(keeper ->
                        keeper instanceof ChangeKeeping)
                .collect(toList());
    }

    public List<Keeper> getTicketKeepers() {
        return this.keepers
                .stream()
                .filter(keeper ->
                        keeper instanceof TicketsKeeping)
                .collect(toList());
    }

    public void setKeepers(List<Keeper> keepers) {
        this.keepers = keepers;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }
}

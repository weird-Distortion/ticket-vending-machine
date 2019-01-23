package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Service;

@Service
public class MachineInitializer {

    public Machine initializeMachine() {
        Machine machine = new Machine();

        //todo encapsulate using class that holds creators
        for (CoinCreator coinType : CoinCreator.values()) {
            machine.getChangeKeepers()
                    .forEach(keeper -> keeper.addToKeeper(
                            String.valueOf(coinType.createNewCoin().getCoinCost()),
                            50));
        }

        for (TicketCreator ticketType : TicketCreator.values()) {
            machine.getTicketKeepers()
                    .forEach(keeper -> keeper.addToKeeper(
                            ticketType.createNewTicket().getTicketType(),
                            50));
        }

        return machine;
    }
}

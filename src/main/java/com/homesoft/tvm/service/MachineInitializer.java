package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Service;

@Service
public class MachineInitializer {

    public Machine initializeMachine() {
        Machine machine = new Machine();

        //todo: encapsulate somehow (?)
        for (CoinCreator coinType : CoinCreator.values()) {
            machine.getChangeKeeper()
                    .addToKeeper(machine.getChangeKeeper().getMap(),
                            coinType.createNewCoin(),
                            50);
        }

        for (TicketCreator ticketType : TicketCreator.values()) {
            machine.getTicketKeeper()
                    .addToKeeper(machine.getTicketKeeper().getMap(),
                            ticketType.createNewTicket().getType(),
                            50);
        }

        return machine;
    }
}

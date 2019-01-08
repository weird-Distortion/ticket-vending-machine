package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Service;

@Service
public class MachineInitializer {

    public Machine initializeMachine() {
        Machine machine = new Machine();

        for (CoinCreator coinType : CoinCreator.values()) {
            machine.getChangeKeeper()
                    .addToKeeper(coinType.createNewCoin(), 50);
        }

        for (TicketCreator ticketType : TicketCreator.values()) {
            machine.getTicketKeeper()
                    .addToKeeper(ticketType.createNewTicket().getType(), 50);
        }

        return machine;
    }
}

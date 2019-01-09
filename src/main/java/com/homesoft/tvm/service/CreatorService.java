package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Coin;
import com.homesoft.tvm.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {

    public Ticket getNewTicket(String ticketType) {
        return TicketCreator.valueOf(ticketType).createNewTicket();
    }

    public Coin getNewCoin(String coinType) {
        return CoinCreator.valueOf(coinType).createNewCoin();
    }
}

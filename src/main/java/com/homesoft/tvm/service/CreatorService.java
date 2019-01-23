package com.homesoft.tvm.service;

import com.homesoft.tvm.model.CoinInterface;
import com.homesoft.tvm.model.TicketInterface;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {

    public TicketInterface getNewTicket(String ticketType) {
        return TicketCreator.valueOf(ticketType).createNewTicket();
    }

    public CoinInterface getNewCoin(String coinType) {
        return CoinCreator.valueOf(coinType).createNewCoin();
    }
}

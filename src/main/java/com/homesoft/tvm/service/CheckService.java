package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.model.Ticket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckService {

    public boolean isCoinFake(Machine machine, String userMoney) {
        return !machine.getChangeKeeper()
                .getMap()
                .keySet()
                .contains(userMoney);

    }

    public boolean isEnoughMoney(Ticket ticketType, List<String> userMoney) {
        BigDecimal userMoneyTotal = new BigDecimal("0.0");
        userMoney.forEach(coin -> userMoneyTotal.add(BigDecimal.valueOf(Double.valueOf(coin))));

        return ticketType.getTicketCost().compareTo(userMoneyTotal) <= 0;

    }
}

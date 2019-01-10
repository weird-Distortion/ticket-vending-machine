package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.model.Ticket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckService {

    public boolean isMoneyAreReal(Machine machine, List<String> userMoney) {
        if (machine.getChangeKeeper()
                .getMap()
                .keySet()
                .containsAll(userMoney)) {

            System.out.println("There is fake money");
            return true;
        }

        return false;
    }

    public boolean isEnoughMoney(Ticket ticketType, List<String> userMoney) {
        BigDecimal userMoneyTotal = new BigDecimal("0.0");
        userMoney.forEach(coin -> userMoneyTotal.add(BigDecimal.valueOf(Double.valueOf(coin))));

        return ticketType.getTicketCost().compareTo(userMoneyTotal) <= 0;

    }
}

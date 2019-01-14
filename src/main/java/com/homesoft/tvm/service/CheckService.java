package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.model.Ticket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
        for (String coin : userMoney) {
            userMoneyTotal = userMoneyTotal.add(BigDecimal.valueOf(Double.valueOf(coin)));
        }

        return ticketType.getTicketCost().compareTo(userMoneyTotal) <= 0;
    }

    public String checkForLeft(List<String> userInput, Ticket ticket) {
        BigDecimal sum =
                userInput.stream()
                        .map(coin -> BigDecimal.valueOf(Double.parseDouble(coin)))
                .collect(toList())
                .stream()
                .reduce(BigDecimal::add)
                .orElseGet(ticket::getTicketCost);

        BigDecimal result = ticket.getTicketCost().subtract(sum);

        return String.valueOf(result);
    }
}

package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Coin;
import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.model.Ticket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MachineService {

    public void giveOutTicket(Machine machine, String type) {
        machine.getTicketKeeper().giveOut(type);
    }

    public List<String> giveOutChange(Machine machine, Ticket ticketType, List<String> userMoney) {

        List<String> resultChangeList = new ArrayList<>();
        List<String> availableChangeList = getAvailableChangeCoins(machine);
        BigDecimal userMoneyTotal = countUserMoneyTotal(userMoney);
        BigDecimal changeToGiveOut = userMoneyTotal.subtract(ticketType.getTicketCost());

        for (int i = availableChangeList.size() - 1; i > 0; i--) {
            BigDecimal coinToCompare = BigDecimal.valueOf(Double.valueOf(availableChangeList.get(i)));

            if (changeToGiveOut.compareTo(coinToCompare) >= 0) {
                changeToGiveOut = changeToGiveOut.subtract(coinToCompare);
                machine.getChangeKeeper().giveOut(String.valueOf(coinToCompare));
                resultChangeList.add(String.valueOf(coinToCompare));
                i++;
            }
        }

        resultChangeList.sort(Comparable::compareTo);

        return resultChangeList;
    }

    private BigDecimal countUserMoneyTotal(List<String> userMoney) {

        return userMoney.stream()
                .map(coin ->
                        new BigDecimal(String.valueOf(coin)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean isEnoughChange(Machine machine, Coin coinType) {

        return false;
    }

    private List<String> getAvailableChangeCoins(Machine machine) {

        List<String> availableChangeList = new ArrayList<>();

        machine.getChangeKeeper()
                .getMap()
                .keySet()
                .forEach(key ->
                        availableChangeList.add(String.valueOf(key)));

        availableChangeList.sort(Comparable::compareTo);
        return availableChangeList;
    }
}

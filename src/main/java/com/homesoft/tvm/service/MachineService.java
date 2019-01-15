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

    public String giveOutTicket(Machine machine, String type) {
        return machine.getTicketKeeper().giveOut(type);
    }

    public List<String> giveOutChange(Machine machine, Ticket ticketType, List<String> userMoney) {

        List<String> resultChangeList = new ArrayList<>();
        List<String> availableChangeList = getAvailableChangeCoins(machine);
        BigDecimal userMoneyTotal = countUserMoneyTotal(userMoney);
        BigDecimal changeToGiveOut = userMoneyTotal.subtract(ticketType.getTicketCost());

        for (int i = availableChangeList.size() - 1; i > 0; i--) {
            BigDecimal coinToCompare = BigDecimal.valueOf(Double.valueOf(availableChangeList.get(i)));

            if (changeToGiveOut.compareTo(coinToCompare) >= 0) {

                if (!machine.getChangeKeeper().giveOut(String.valueOf(coinToCompare)).equals("-1")) {
                    changeToGiveOut = changeToGiveOut.subtract(coinToCompare);
                    resultChangeList.add(machine.getChangeKeeper().giveOut(String.valueOf(coinToCompare)));
                    i++;
                }
            }
        }

        resultChangeList.sort(Comparable::compareTo);

        if (isEnoughChange(changeToGiveOut)) return resultChangeList;

        return userMoney;
    }

    private BigDecimal countUserMoneyTotal(List<String> userMoney) {

        return userMoney.stream()
                .map(coin ->
                        new BigDecimal(String.valueOf(coin)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private boolean isEnoughChange(BigDecimal changeToGiveOut) {

        return changeToGiveOut.compareTo(BigDecimal.ZERO) == 0;
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

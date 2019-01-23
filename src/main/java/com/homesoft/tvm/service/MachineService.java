package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.model.Ticket;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

@Service
public class MachineService {

    public String giveOutTicket(Machine machine, String type) {
        return machine
                .getTicketKeepers()
                .stream()
                .map(keeper ->
                        keeper.giveOut(type))
                .collect(joining(", "));
    }

    public List<String> giveOutChange(Machine machine, Ticket ticketType, List<String> userMoney) {

        List<String> resultChangeList = new ArrayList<>();
        List<String> availableChangeList = getAvailableChangeCoins(machine);
        BigDecimal userMoneyTotal = countUserMoneyTotal(userMoney);
        BigDecimal changeToGiveOut = userMoneyTotal.subtract(ticketType.getTicketCost());

        for (int i = availableChangeList.size() - 1; i > 0; i--) {
            BigDecimal coinToCompare = BigDecimal.valueOf(Double.valueOf(availableChangeList.get(i)));

            if (changeToGiveOut.compareTo(coinToCompare) >= 0 &&
                    !machine.getChangeKeepers()
                            .stream()
                            .map(keeper ->
                                    keeper.giveOut(String.valueOf(coinToCompare)))
                            .collect(joining(", "))
                            .equals("-1")) {

                changeToGiveOut = changeToGiveOut.subtract(coinToCompare);
                resultChangeList
                        .add(machine.getChangeKeepers()
                                .stream()
                                .map(keeper ->
                                        keeper.giveOut(String.valueOf(coinToCompare)))
                                .collect(joining()));
                i++;
            }
        }

        resultChangeList.sort(Comparable::compareTo);

        if (

                isEnoughChange(changeToGiveOut)) return resultChangeList;

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

        machine.getChangeKeepers()
                .forEach(keeper ->
                        keeper.getMap()
                                .keySet()
                                .forEach(key ->
                                        availableChangeList.add(String.valueOf(key))));

        availableChangeList.sort(Comparable::compareTo);
        return availableChangeList;
    }

    public void fillChangeKeeper(Machine machine) {
        //todo to encapsulate
        machine.getChangeKeepers()
                .forEach(keeper ->
                        keeper.getMap()
                                .keySet()
                                .forEach(coinType ->
                                        keeper.getMap()
                                                .computeIfPresent(coinType, (k, v) -> v + 50)));
    }

    public void fillTicketKeeper(Machine machine) {
        //todo to encapsulate
        machine.getTicketKeepers()
                .forEach(keeper ->
                        keeper.getMap()
                                .keySet()
                                .forEach(ticketType ->
                                        keeper.getMap()
                                                .computeIfPresent(ticketType, (k, v) -> v + 50)));
    }
}

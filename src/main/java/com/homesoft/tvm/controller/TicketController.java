package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Coin;
import com.homesoft.tvm.model.CoinInterface;
import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.service.CheckService;
import com.homesoft.tvm.service.CreatorService;
import com.homesoft.tvm.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class TicketController {

    @Autowired
    private MachineService machineService;

    @Autowired
    private CreatorService creatorService;

    @Autowired
    private CheckService checkService;

    @ModelAttribute("userCoin")
    public CoinInterface setUpCoin() {
        return new Coin("0 Betelgeuse coin","0");
    }

    @GetMapping(value = "/ticket")
    public String showTicketPage(
            @SessionAttribute("machine") Machine machine,
            @SessionAttribute("userInputList") ArrayList<String> userInputList,
            @RequestParam String id,
            @ModelAttribute("userCoin") CoinInterface coin,
            ModelMap model) {

        if (machineService.giveOutTicket(machine, creatorService.getNewTicket(id).getTicketType()).equals("-1")) {
            model.addAttribute("resultText", "There is no available tickets!");
            return "success";
        }

        List<String> availableCoinList =
                machine.getChangeKeepers()
                        .stream()
                        .flatMap(keeper ->
                                keeper.getMap().keySet().stream())
                        .sorted()
                        .collect(toList());

        if (userInputList.isEmpty()) {
            model.addAttribute("moneyLeft", creatorService.getNewTicket(id).getTicketCost());
        } else {
            model.addAttribute("moneyLeft", checkService.checkForLeft(userInputList, creatorService.getNewTicket(id)));
        }
        model.addAttribute("ticketType", creatorService.getNewTicket(id).getTicketType());
        model.addAttribute("ticketCost", creatorService.getNewTicket(id).getTicketCost());
        model.addAttribute("coinsAvailable", availableCoinList);


        return "ticket";
    }

    @PostMapping(value = "/ticket")
    public String insertCoin(
            @SessionAttribute("machine") Machine machine,
            @SessionAttribute("userInputList") ArrayList<String> userInputList,
            @RequestParam String id,
            @ModelAttribute("userCoin") CoinInterface coin,
            ModelMap model) {

        if (checkService.isCoinFake(machine, String.valueOf(coin.getCoinCost()))) {
            userInputList.clear();
            return "busted";
        }

        machine.getUserInput().insertNewCoin(String.valueOf(coin.getCoinCost()));
        userInputList.add(String.valueOf(coin.getCoinCost()));

        if (checkService.isEnoughMoney(creatorService.getNewTicket(id), userInputList)) {
            List<String> tempChange = machineService.giveOutChange(machine, creatorService.getNewTicket(id), userInputList);

            if (userInputList.containsAll(tempChange)
                    && userInputList.size() == tempChange.size()) {
                model.addAttribute("resultText", "There is no change!");
                model.addAttribute("resultList", userInputList);
                userInputList.clear();
                return "success";
            }

            model.addAttribute("resultText", "Success!");
            model.addAttribute("resultList", tempChange);
            model.addAttribute("ticketType", creatorService.getNewTicket(id).getTicketType());
            userInputList.clear();
            return "success";
        }

        model.addAttribute("userInputList", userInputList);

        return "redirect:/ticket?id=" + id;
    }
}

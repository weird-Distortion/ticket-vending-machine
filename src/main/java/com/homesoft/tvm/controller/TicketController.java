package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Coin;
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

@Controller
public class TicketController {

    @Autowired
    private MachineService machineService;

    @Autowired
    private CreatorService creatorService;

    @Autowired
    private CheckService checkService;

    @ModelAttribute("userCoin")
    public Coin setUpCoin() {
        return new Coin("0");
    }

    @GetMapping(value = "/ticket")
    public String showTicketPage(
            @SessionAttribute("machine") Machine machine,
            @SessionAttribute("userInputList") ArrayList<String> userInputList,
            @RequestParam String id,
            @ModelAttribute("userCoin") Coin coin,
            ModelMap model) {

        if (machineService.giveOutTicket(machine, creatorService.getNewTicket(id).getType()).equals("-1")) {
            model.addAttribute("resultText", "There is no available tickets!");
            return "success";
        }

        model.addAttribute("ticketType", creatorService.getNewTicket(id).getType());
        model.addAttribute("ticketCost", creatorService.getNewTicket(id).getTicketCost());
        model.addAttribute("moneyLeft", checkService.checkForLeft(userInputList, creatorService.getNewTicket(id)));

        return "ticket";
    }

    @PostMapping(value = "/ticket")
    public String insertCoin(
            @SessionAttribute("machine") Machine machine,
            @SessionAttribute("userInputList") ArrayList<String> userInputList,
            @RequestParam String id,
            @ModelAttribute("userCoin") Coin coin,
            ModelMap model) {

        if (checkService.isCoinFake(machine, String.valueOf(coin.getCoinValue()))) {
            userInputList.clear();
            return "busted";
        }

        machine.getUserInput().insertNewCoin(String.valueOf(coin.getCoinValue()));
        userInputList.add(String.valueOf(coin.getCoinValue()));

        if (checkService.isEnoughMoney(creatorService.getNewTicket(id), userInputList)) {
            List<String> tempChange = machineService.giveOutChange(machine, creatorService.getNewTicket(id), userInputList);

            if (userInputList.containsAll(tempChange)
                    && userInputList.size() == tempChange.size()) {
                model.addAttribute("resultText", "There is no change!");
                model.addAttribute("resultList", userInputList);

                return "success";
            }

            model.addAttribute("resultText", "OK! Here is your change");
            model.addAttribute("resultList", tempChange);
            return "success";
        }

        model.addAttribute("userInputList", userInputList);

        return "redirect:/ticket?id=" + id;
    }
}

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
            @SessionAttribute("userInputList") ArrayList userInputList,
            @RequestParam String id,
            @ModelAttribute("userCoin") Coin coin,
            ModelMap model) {

        model.addAttribute("ticketType", creatorService.getNewTicket(id).getType());
        model.addAttribute("userInput", userInputList);
//        machineLogic.giveOutTicket(machine, TicketCreator.valueOf(id).createNewTicket().getType());

        return "ticket";
    }

    @PostMapping(value = "/ticket")
    public String insertCoin(
            @SessionAttribute("machine") Machine machine,
            @SessionAttribute("userInputList") ArrayList<String> userInputList,
            @RequestParam String id,
            @ModelAttribute("userCoin") Coin coin,
            ModelMap model) {

        //check coin if it's fake ot not TODO: create explicit page to bust the forger
        if (checkService.isCoinFake(machine, String.valueOf(coin.getCoinValue()))) {
            userInputList.clear();
            return "redirect:/index";
        }

        machine.getUserInput().insertNewCoin(String.valueOf(coin.getCoinValue()));
        userInputList.add(String.valueOf(coin.getCoinValue()));

        model.addAttribute("userInputList", userInputList);

//        machine.getUserInput().getUserInputList().forEach(System.out::println);

        return "redirect:/ticket?id=" + id;
    }
}

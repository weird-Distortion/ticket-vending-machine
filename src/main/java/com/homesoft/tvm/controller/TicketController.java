package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Coin;
import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.service.MachineService;
import com.homesoft.tvm.service.TicketCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {

    @Autowired
    private MachineService machineService;

    @ModelAttribute("userCoin")
    public Coin setUpCoin() {
        return new Coin("0");
    }

    @GetMapping(value = "/ticket")
    public String showTicketPage(
            @SessionAttribute("machine") Machine machine,
            @RequestParam String id,
            @ModelAttribute("userCoin") Coin coin,
            ModelMap model) {

        model.addAttribute("ticketType", TicketCreator.valueOf(id).createNewTicket().getType());
//        machineLogic.giveOutTicket(machine, TicketCreator.valueOf(id).createNewTicket().getType());

        return "ticket";
    }

    @PostMapping(value = "/ticket")
    public String insertCoin(
            @SessionAttribute("machine") Machine machine,
            @RequestParam String id,
            @ModelAttribute("userCoin") Coin coin,
            ModelMap model) {

        machine.getUserInput().insertNewCoin(String.valueOf(coin.getCoinValue()));

//        machine.getUserInput().getUserInputList().forEach(System.out::println);

        return "redirect:/ticket?id=" + id;
    }
}

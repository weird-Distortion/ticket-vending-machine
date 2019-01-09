package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Coin;
import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.model.Ticket;
import com.homesoft.tvm.service.CoinCreator;
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

    @ModelAttribute("theCoin")
    public Coin setUpCoin() {
        return new Coin("0");
    }

    @GetMapping(value = "/ticket")
    public String showTicketPage(
            @SessionAttribute("machine") Machine machine,
            @RequestParam String id,
            @ModelAttribute("theCoin") Coin coin,
            ModelMap model) {

        Ticket tempTicket = TicketCreator.valueOf(id).createNewTicket();
        model.addAttribute("ticketType", tempTicket.getType());
        model.addAttribute("coinAtt", coin);
//        machineLogic.giveOutTicket(machine, TicketCreator.valueOf(id).createNewTicket().getType());

        return "ticket";
    }
}

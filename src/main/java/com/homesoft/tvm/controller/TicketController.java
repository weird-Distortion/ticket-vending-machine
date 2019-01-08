package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.service.MachineLogic;
import com.homesoft.tvm.service.TicketCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class TicketController {

    @Autowired
    private MachineLogic machineLogic;

    @GetMapping(value = "/ticket")
    public String showTicketPage(
            @SessionAttribute("machine") Machine machine,
            @RequestParam String id,
            ModelMap model) {

        model.addAttribute("ticketType", id);
        machineLogic.giveOutTicket(machine, TicketCreator.valueOf(id).createNewTicket().getType());

        return "ticket";
    }
}

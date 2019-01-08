package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.service.TicketCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "machine")
public class IndexController {

    @ModelAttribute
    public Machine getSessionMachine() {
        return new Machine();
    }

    @GetMapping
    public String showMainPage(
            @ModelAttribute("machine") Machine machine,
            ModelMap model) {

        model.addAttribute("ticketTypes", TicketCreator.values());

        return "index";
    }
}

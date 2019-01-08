package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class TicketController {

    @GetMapping(value = "/ticket")
    public String showTicketPage(
            @SessionAttribute Machine machine,
            @RequestParam String id,
            ModelMap model) {

        model.addAttribute("ticketType", id);
        return "ticket";
    }
}

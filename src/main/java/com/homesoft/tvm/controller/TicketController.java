package com.homesoft.tvm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    @GetMapping(value = "/ticket")
    public String showTicketPage(
            @RequestParam String id,
            ModelMap model) {

        model.addAttribute("ticketType", id);
        return "ticket";
    }
}

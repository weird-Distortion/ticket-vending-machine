package com.homesoft.tvm.controller;

import com.homesoft.tvm.service.TicketCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String showMainPage(ModelMap model) {

        model.addAttribute("ticketTypes", TicketCreator.values());

        return "index";
    }
}

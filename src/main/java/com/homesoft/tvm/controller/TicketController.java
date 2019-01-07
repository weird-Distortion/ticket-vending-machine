package com.homesoft.tvm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {

    @GetMapping(value = "ticket")
    public String showTicketPage() {

        return "ticket";
    }
}

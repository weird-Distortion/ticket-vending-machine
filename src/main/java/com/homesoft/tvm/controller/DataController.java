package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class DataController {

    @GetMapping(value = "/machine-data")
    public String showDataPage(
            @SessionAttribute("machine") Machine machine,
            ModelMap model) {

        model.addAttribute("tickets", machine.getTicketKeeper().getMap());
        model.addAttribute("coins", machine.getChangeKeeper().getMap());

        return "machine-data";
    }
}

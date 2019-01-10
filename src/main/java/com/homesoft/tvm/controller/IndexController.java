package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.service.MachineInitializer;
import com.homesoft.tvm.service.TicketCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"machine", "userInputList"})
public class IndexController {

    @Autowired
    private MachineInitializer machineInitializer;

    @ModelAttribute("machine")
    public Machine getSessionMachine() {
        return machineInitializer.initializeMachine();
    }

    @ModelAttribute("userInputList")
    public List<String> getSessionUserInputList() {
        return new ArrayList<>();
    }

    @GetMapping
    public String showMainPage(
            @ModelAttribute("machine") Machine machine,
            @ModelAttribute("userInputList") ArrayList userInputList,
            ModelMap model) {

        model.addAttribute("ticketTypes", TicketCreator.values());

        return "index";
    }
}

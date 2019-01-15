package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Coin;
import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.service.MachineInitializer;
import com.homesoft.tvm.service.MachineService;
import com.homesoft.tvm.service.TicketCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"machine", "userInputList"})
public class IndexController {

    @Autowired
    private MachineInitializer machineInitializer;

    @Autowired
    private MachineService machineService;

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

    @PostMapping
    public String fillMachine(
            @SessionAttribute("machine") Machine machine,
            ModelMap model) {

        machineService.fillTicketKeeper(machine);
        machineService.fillChangeKeeper(machine);
        System.out.println(machine.getTicketKeeper().getMap().keySet().toString());
        System.out.println(machine.getTicketKeeper().getMap().values().toString());
        System.out.println();
        System.out.println(machine.getChangeKeeper().getMap().keySet().toString());
        System.out.println(machine.getChangeKeeper().getMap().values().toString());

        return "redirect:/index";
    }
}

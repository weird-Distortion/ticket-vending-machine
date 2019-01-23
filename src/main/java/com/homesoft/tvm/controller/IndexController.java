package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import com.homesoft.tvm.service.MachineInitializer;
import com.homesoft.tvm.service.MachineService;
import com.homesoft.tvm.service.TicketCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

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

    @GetMapping(value = "/index")
    public String showMainPage(ModelMap model) {

        Map<String, String> ticketMap =
                Arrays.stream(TicketCreator.values())
                        .collect(toMap(String::valueOf, id ->
                                id.createNewTicket().getType()));

        model.addAttribute("ticketTypes", ticketMap);

        return "index";
    }

    @PostMapping(value = "/index")
    public String fillMachine(
            @SessionAttribute("machine") Machine machine,
            ModelMap model) {

        machineService.fillTicketKeeper(machine);
        machineService.fillChangeKeeper(machine);

        return "redirect:/index";
    }
}

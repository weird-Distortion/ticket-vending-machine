package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

@Controller
public class DataController {

    @GetMapping(value = "/machine-data")
    public String showDataPage(
            @SessionAttribute("machine") Machine machine,
            ModelMap model) {

        model.addAttribute("tickets",
                machine.getTicketKeepers()
                        .stream()
                        .flatMap(keeper ->
                                keeper.getMap()
                                        .entrySet()
                                        .stream())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue))
                        .entrySet()
                        .stream()
                        .sorted(comparingByKey())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new)));

        model.addAttribute("coins",
                machine.getChangeKeepers()
                        .stream()
                        .flatMap(keeper ->
                                keeper.getMap()
                                        .entrySet()
                                        .stream())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue))
                        .entrySet()
                        .stream()
                        .sorted(comparingByKey())
                        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new)));

        return "machine-data";
    }
}

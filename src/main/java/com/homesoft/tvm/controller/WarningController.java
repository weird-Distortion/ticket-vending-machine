package com.homesoft.tvm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;

@Controller
public class WarningController {

    @GetMapping(value = "/warning")
    public String showWarningPage(
            @SessionAttribute("userInputList") ArrayList<String> userInputList,
            ModelMap model) {
        model.addAttribute("userInputList", userInputList);

        return "warning";
    }

    @PostMapping(value = "/warning")
    public String cancelTransaction(@SessionAttribute("userInputList") ArrayList<String> userInputList) {
        userInputList.clear();

        return "redirect:/index";
    }
}

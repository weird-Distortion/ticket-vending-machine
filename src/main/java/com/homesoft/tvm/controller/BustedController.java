package com.homesoft.tvm.controller;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class BustedController {

    @GetMapping(value = "/busted")
    public String showBustedPage(@SessionAttribute("machine") Machine machine) {

        return "busted";
    }
}

package com.homesoft.tvm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BustedController {

    @GetMapping(value = "/busted")
    public String showBustedPage() {

        return "success";
    }
}
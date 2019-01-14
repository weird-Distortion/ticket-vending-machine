package com.homesoft.tvm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {

    @GetMapping(value = "/success")
    public String showSuccessPage() {


        return "success";
    }

}

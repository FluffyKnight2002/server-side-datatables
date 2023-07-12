package com.test.serverside_datatables.controller;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class CityController {


    @GetMapping("/")
    public String homePage() {
        return "List";
    }

    @GetMapping("/cardPage")
    public String card() {
        return "Card";
    }


}
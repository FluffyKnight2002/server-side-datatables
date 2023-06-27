package com.test.serverside_datatables.controller;


import com.test.serverside_datatables.repository.CityRepo;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class CityController {

    private final CityRepo cityRepo;
    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @GetMapping("/")
    public String homePage() {
        return "List";
    }


}
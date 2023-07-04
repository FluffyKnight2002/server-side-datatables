package com.test.serverside_datatables.controller;

import com.test.serverside_datatables.entity.City;
import com.test.serverside_datatables.repository.CityRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Rest {

    private final CityRepo cityRepo;
    @GetMapping("/user")

    public DataTablesOutput<City> getEmployees(@Valid DataTablesInput input) {
        return cityRepo.findAll(input);
    }
}

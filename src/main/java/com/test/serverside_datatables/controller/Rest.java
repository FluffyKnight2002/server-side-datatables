package com.test.serverside_datatables.controller;

import com.test.serverside_datatables.entity.City;
import com.test.serverside_datatables.repository.CityRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Rest {

    private final CityRepo cityRepo;
    private static final Logger logger= LoggerFactory.getLogger(Rest.class);
    @GetMapping("/user")

    public DataTablesOutput<City> getEmployees(@Valid DataTablesInput input) {
//        DataTablesOutput<City> output = new DataTablesOutput<>();
//        output.setDraw(input.getDraw());
//
//        int pageSize = input.getLength(); // Number of entries to show per page
//        int pageNumber = input.getStart() / pageSize; // Current page number
//
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        Page<City> city = cityRepo.findAll(pageable);
//
//        output.setData(city.getContent());
//        output.setRecordsTotal(cityRepo.count());
//        output.setRecordsFiltered(cityRepo.count());

            logger.info("yes");

        return cityRepo.findAll(input);
    }
}

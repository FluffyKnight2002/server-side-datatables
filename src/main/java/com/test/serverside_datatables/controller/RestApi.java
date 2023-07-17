package com.test.serverside_datatables.controller;

import com.test.serverside_datatables.entity.City;
import com.test.serverside_datatables.repository.CityRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class RestApi {

    private final CityRepo cityRepo;
    @GetMapping("/user")

    public DataTablesOutput<City> getEmployees(@Valid DataTablesInput input) {
        return cityRepo.findAll(input);
    }

    @GetMapping("/card")
    public ResponseEntity<Page<City>> getCityPage(@RequestParam(defaultValue = "0") int pageNumber,
                                                  @RequestParam(defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<City> cityPage = cityRepo.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(cityPage);
    }
}

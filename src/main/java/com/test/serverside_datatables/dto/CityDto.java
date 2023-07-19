package com.test.serverside_datatables.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    private long id;


    private String name;


    private String countrycode;


    private String district;


    private int population;
}

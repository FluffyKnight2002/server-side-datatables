package com.test.serverside_datatables.controller;

import com.test.serverside_datatables.dto.UserDto;
import com.test.serverside_datatables.entity.City;
import com.test.serverside_datatables.entity.User;
import com.test.serverside_datatables.repository.CityRepo;
import com.test.serverside_datatables.repository.UserRepo;
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

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
public class RestApi {

    private final CityRepo cityRepo;
    private final UserRepo userRepo;
    @GetMapping("/city")
    public DataTablesOutput<City> getCities(@Valid DataTablesInput input) {
        return cityRepo.findAll(input);
    }

    @GetMapping("/user")
    public DataTablesOutput<UserDto> getUsers(@Valid DataTablesInput input) {
        DataTablesOutput<User> usersOutput = userRepo.findAll(input);
        List<UserDto> userDtos = new ArrayList<>();
        for(User user:usersOutput.getData()){
            UserDto userDto=new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDtos.add(userDto);
        }
        DataTablesOutput<UserDto>userDtoDataTablesOutput=new DataTablesOutput<>();
        userDtoDataTablesOutput.setData(userDtos);
        userDtoDataTablesOutput.setDraw(usersOutput.getDraw());
        userDtoDataTablesOutput.setError(usersOutput.getError());
        userDtoDataTablesOutput.setSearchPanes(usersOutput.getSearchPanes());
        userDtoDataTablesOutput.setRecordsFiltered(usersOutput.getRecordsFiltered());
        userDtoDataTablesOutput.setRecordsTotal(usersOutput.getRecordsTotal());

        return userDtoDataTablesOutput;
    }


    @GetMapping("/card")
    public ResponseEntity<Page<City>> getCityPage(@RequestParam(defaultValue = "0") int pageNumber,
                                                  @RequestParam(defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<City> cityPage = cityRepo.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(cityPage);
    }
}

package com.test.serverside_datatables.repository;

import com.test.serverside_datatables.entity.City;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;







public interface CityRepo extends DataTablesRepository <City, Integer> {
}

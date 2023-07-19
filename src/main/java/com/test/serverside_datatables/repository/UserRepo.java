package com.test.serverside_datatables.repository;

import com.test.serverside_datatables.entity.User;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

public interface UserRepo extends DataTablesRepository<User, Long> {
}

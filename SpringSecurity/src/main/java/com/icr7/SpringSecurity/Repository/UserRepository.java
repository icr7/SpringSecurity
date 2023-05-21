package com.icr7.SpringSecurity.Repository;

import com.icr7.SpringSecurity.Model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserTable,Integer> {
    Optional<UserTable> findByUserName(String userName);
}

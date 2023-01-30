package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}

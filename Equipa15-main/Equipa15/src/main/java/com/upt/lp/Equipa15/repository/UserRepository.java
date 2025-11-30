package com.upt.lp.Equipa15.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upt.lp.Equipa15.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{}
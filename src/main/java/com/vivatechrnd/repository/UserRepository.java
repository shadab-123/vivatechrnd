package com.vivatechrnd.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vivatechrnd.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}

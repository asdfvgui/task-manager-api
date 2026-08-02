package com.asdfvgui.taskmanagerapi.repository;

import com.asdfvgui.taskmanagerapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

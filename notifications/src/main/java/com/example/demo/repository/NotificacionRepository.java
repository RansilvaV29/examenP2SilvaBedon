package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Notification;

public interface NotificacionRepository extends JpaRepository<Notification, Long>{

}

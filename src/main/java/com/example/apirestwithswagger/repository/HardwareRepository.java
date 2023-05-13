package com.example.apirestwithswagger.repository;

import com.example.apirestwithswagger.entities.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepository extends JpaRepository<Hardware, Long> {
}

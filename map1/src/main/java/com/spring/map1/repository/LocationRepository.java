package com.spring.map1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.map1.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    // You can add custom query methods if needed
}

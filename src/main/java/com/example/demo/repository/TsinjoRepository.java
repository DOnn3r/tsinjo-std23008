package com.example.demo.repository;

import com.example.demo.model.Tsinjo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TsinjoRepository extends JpaRepository<Tsinjo, Integer> {
    default Tsinjo findSingle() {
        return findAll().stream().findFirst().orElseThrow();
    }
}
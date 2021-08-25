package com.example.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Dvd;

@Repository
public interface DvdRepository extends JpaRepository<Dvd, Long> {

}

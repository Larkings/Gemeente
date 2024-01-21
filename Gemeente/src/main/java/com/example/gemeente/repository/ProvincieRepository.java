package com.example.gemeente.repository;

import com.example.gemeente.model.Provincie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvincieRepository extends JpaRepository<Provincie, Integer> {
}

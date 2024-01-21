package com.example.gemeente.repository;

import com.example.gemeente.model.Gemeente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GemeenteRepository extends JpaRepository<Gemeente, String> {
  List<Gemeente> findAllByOrderByInwonersDesc();
  List<Gemeente> findAllByOrderByGemeenteAsc();
}

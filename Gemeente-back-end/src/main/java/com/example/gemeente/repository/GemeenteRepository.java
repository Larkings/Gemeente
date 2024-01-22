package com.example.gemeente.repository;

import com.example.gemeente.model.Gemeente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GemeenteRepository extends JpaRepository<Gemeente, String> {
  Optional<Gemeente> findByGemeente(String gemeente);
  List<Gemeente> findAllByOrderByInwonersDesc();
  List<Gemeente> findAllByOrderByGemeenteAsc();
}

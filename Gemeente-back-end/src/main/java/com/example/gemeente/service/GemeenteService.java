package com.example.gemeente.service;

import com.example.gemeente.model.Gemeente;
import com.example.gemeente.repository.GemeenteRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.io.InputStream;
import java.util.List;

@Service
public class GemeenteService {

  private final GemeenteRepository gemeenteRepository;

  public GemeenteService(GemeenteRepository gemeenteRepository) {
    this.gemeenteRepository = gemeenteRepository;
  }

  @PostConstruct
  public void init() {
    try {
      InputStream inputStream = new ClassPathResource("gemeenten.json").getInputStream();
      ObjectMapper mapper = new ObjectMapper();

      List<Gemeente> gemeenten = mapper.readValue(inputStream, new TypeReference<>() {
      });

      gemeenteRepository.saveAll(gemeenten);
    } catch (Exception e) {
      e.getMessage();
    }
  }

  public List<Gemeente> getAllGemeenten() {
    return gemeenteRepository.findAll();
  }

  public Gemeente getGemeenteByGemeente(String gemeente) {
    return gemeenteRepository.findByGemeente(gemeente)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gemeente niet gevonden"));
  }

  public List<Gemeente> getGemeentenGesorteerdOpInwoners() {
    return gemeenteRepository.findAllByOrderByInwonersDesc();
  }

  public List<Gemeente> getGemeentenGesorteerdAlfabetisch() {
    return gemeenteRepository.findAllByOrderByGemeenteAsc();
  }
}

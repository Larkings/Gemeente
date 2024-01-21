package com.example.gemeente.service;


import com.example.gemeente.repository.ProvincieRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvincieService {

  private final ProvincieRepository provincieRepository;

  public ProvincieService(ProvincieRepository provincieRepository) {
    this.provincieRepository = provincieRepository;
  }
}

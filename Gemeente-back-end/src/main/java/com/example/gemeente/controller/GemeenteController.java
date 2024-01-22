package com.example.gemeente.controller;

import com.example.gemeente.model.Gemeente;
import com.example.gemeente.service.GemeenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gemeenten")
public class GemeenteController {

  @Autowired
  private GemeenteService gemeenteService;

  @GetMapping
  public List<Gemeente> getAllGemeenten() {
    return gemeenteService.getAllGemeenten();
  }

  @GetMapping("/{gemeente}")
  public ResponseEntity<Gemeente> getGemeenteByGemeente(@PathVariable String gemeente) {
    Gemeente result = gemeenteService.getGemeenteByGemeente(gemeente);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/sorteer/inwoners")
  public List<Gemeente> getGemeentenGesorteerdOpInwoners() {
    return gemeenteService.getGemeentenGesorteerdOpInwoners();
  }

  @GetMapping("/sorteer/alfabetisch")
  public List<Gemeente> getGemeentenGesorteerdAlfabetisch() {
    return gemeenteService.getGemeentenGesorteerdAlfabetisch();
  }
}

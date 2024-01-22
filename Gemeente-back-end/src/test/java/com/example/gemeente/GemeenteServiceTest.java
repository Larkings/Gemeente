package com.example.gemeente;

import com.example.gemeente.model.Gemeente;
import com.example.gemeente.service.GemeenteService;
import com.example.gemeente.repository.GemeenteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GemeenteServiceTest {

  @InjectMocks
  private GemeenteService gemeenteService;

  @Mock
  private GemeenteRepository gemeenteRepository;

  @BeforeEach
  public void init() {
    try {
      MockitoAnnotations.openMocks(this);
    } catch ( Exception e){
      e.printStackTrace();
    }
  }

  @Test
  public void testGetAllGemeenten() {
    Gemeente gemeente1 = new Gemeente();
    Gemeente gemeente2 = new Gemeente();
    List<Gemeente> expected = Arrays.asList(gemeente1, gemeente2);

    when(gemeenteRepository.findAll()).thenReturn(expected);

    List<Gemeente> actual = gemeenteService.getAllGemeenten();

    assertEquals(expected, actual);
  }

  @Test
  public void testGetGemeente() {
    Gemeente expected = new Gemeente();
    expected.setGemeente("Breda");

    when(gemeenteRepository.findByGemeente("Breda")).thenReturn(Optional.of(expected));

    Gemeente actual = gemeenteService.getGemeenteByGemeente("Breda");

    assertEquals(expected, actual);
  }
}

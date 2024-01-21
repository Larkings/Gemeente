package com.example.gemeente;

import com.example.gemeente.controller.GemeenteController;
import com.example.gemeente.model.Gemeente;
import com.example.gemeente.service.GemeenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GemeenteControllerTest {

  @InjectMocks
  private GemeenteController gemeenteController;

  @Mock
  private GemeenteService gemeenteService;

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

    when(gemeenteService.getAllGemeenten()).thenReturn(expected);

    List<Gemeente> actual = gemeenteController.getAllGemeenten();

    assertEquals(expected, actual);
  }

  @Test
  public void testGetGemeente() {
    Gemeente expected = new Gemeente();
    expected.setId(1);

    when(gemeenteService.getGemeente("1")).thenReturn(expected);

    ResponseEntity<Gemeente> actual = gemeenteController.getGemeente("1");

    assertEquals(ResponseEntity.ok(expected), actual);
  }
}

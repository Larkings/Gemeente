package com.example.gemeente.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "_Provincie")
public class Provincie {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String provincie;
  private String hoofdstad;
  private int oppervlakte;
}

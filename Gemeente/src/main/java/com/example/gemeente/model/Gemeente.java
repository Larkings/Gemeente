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
@Table(name = "_Gemeente")
public class Gemeente {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String gemeente;
  private String provincie;
  private int inwoners;
}

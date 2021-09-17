package com.skokcmd.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "historie")
public class HistoryRecord {

  // id - Primary key
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  @Id
  private UUID id;

  @Column(name = "mesto", nullable = false)
  private String mesto;

  @Temporal(TemporalType.DATE)
  @Column(name = "datum", nullable = false)
  private Date datum;

  @Column(name = "teplota", nullable = false)
  private double teplota;

  public HistoryRecord(String mesto, double teplota) {
    this.mesto = mesto;
    this.teplota = teplota;
    this.datum = new Date();
  }
}

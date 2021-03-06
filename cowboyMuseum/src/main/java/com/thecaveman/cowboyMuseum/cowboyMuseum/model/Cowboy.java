package com.thecaveman.cowboyMuseum.cowboyMuseum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cowboyMuseum")
public class Cowboy {
    @Id
    @GeneratedValue
    private Long cowboyId;
    private String name;
    private String famous;
    private String gun;
    private int money;
}

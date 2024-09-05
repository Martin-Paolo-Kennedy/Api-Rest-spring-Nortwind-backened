package com.martin.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Shippers")
public class Remesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipperID;

    private String shipperName;
    private String phone;

    
}

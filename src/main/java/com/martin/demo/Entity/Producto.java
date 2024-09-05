package com.martin.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    private String productName;
    private String unit;
    private double price;

    @ManyToOne
    @JoinColumn(name = "supplierID")
    private Proveedor supplier;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Categoria category;


}

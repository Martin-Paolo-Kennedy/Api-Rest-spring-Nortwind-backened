package com.martin.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Cliente customer;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Empleado employee;

    @ManyToOne
    @JoinColumn(name = "shipperID")
    private Remesa shipper;


}

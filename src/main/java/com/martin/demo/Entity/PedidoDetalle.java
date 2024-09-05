package com.martin.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OrderDetails")
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailID;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private Pedido order;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Producto product;
}

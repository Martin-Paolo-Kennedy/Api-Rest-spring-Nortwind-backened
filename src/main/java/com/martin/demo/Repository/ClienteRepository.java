package com.martin.demo.Repository;

import com.martin.demo.Entity.Categoria;
import com.martin.demo.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("select a from Cliente a where a.customerName like ?1")
    public List<Cliente> listaPorNombreLike(String nombres);
}

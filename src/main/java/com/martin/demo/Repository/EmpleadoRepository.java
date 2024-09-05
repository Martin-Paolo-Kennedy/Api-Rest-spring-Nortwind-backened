package com.martin.demo.Repository;

import com.martin.demo.Entity.Cliente;
import com.martin.demo.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query("select a from Empleado a where a.firstName like ?1 and (?2 = '' or a.lastName like ?2)")
    public List<Empleado> listaPorNombreLike(String nombre, String apellido);
}

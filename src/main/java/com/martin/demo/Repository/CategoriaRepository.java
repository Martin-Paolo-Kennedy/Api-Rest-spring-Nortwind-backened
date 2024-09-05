package com.martin.demo.Repository;

import com.martin.demo.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query("select a from Categoria a where a.CategoryName like ?1")
    public List<Categoria> listaPorNombreLike(String nombres);
}

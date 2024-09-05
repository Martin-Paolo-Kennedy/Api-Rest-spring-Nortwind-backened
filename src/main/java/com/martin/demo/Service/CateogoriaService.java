package com.martin.demo.Service;

import com.martin.demo.Entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CateogoriaService {
    public abstract List<Categoria> listaCategoria();
    public abstract Categoria insertaActualizaCategoria(Categoria obj);
    public abstract void eliminaCategoria(int idCategoria);
    public abstract List<Categoria> listaCategoriaPorNombreLike(String nombres);
}

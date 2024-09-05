package com.martin.demo.Service;

import com.martin.demo.Entity.Categoria;
import com.martin.demo.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CateogoriaService{
    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listaCategoria() {
        return repository.findAll();
    }

    @Override
    public Categoria insertaActualizaCategoria(Categoria obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaCategoria(int idCategoria) {
        repository.deleteById(idCategoria);
    }

    @Override
    public List<Categoria> listaCategoriaPorNombreLike(String nombres) {
        return repository.listaPorNombreLike(nombres);
    }


}

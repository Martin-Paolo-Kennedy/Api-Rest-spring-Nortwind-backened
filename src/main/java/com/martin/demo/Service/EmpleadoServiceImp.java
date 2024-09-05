package com.martin.demo.Service;

import com.martin.demo.Entity.Empleado;
import com.martin.demo.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public List<Empleado> listaEmpleado() {
        return repository.findAll();
    }

    @Override
    public Empleado insertaActualizaEmpleado(Empleado obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaEmpleado(int idEmpleado) {
        repository.deleteById(idEmpleado);
    }

    @Override
    public List<Empleado> listaEmpleadoPorNombreYApellidoLike(String nombres, String apellidos) {
        return repository.listaPorNombreLike(nombres, apellidos);
    }
}

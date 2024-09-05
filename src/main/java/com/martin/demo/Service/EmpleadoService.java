package com.martin.demo.Service;

import com.martin.demo.Entity.Empleado;

import java.util.List;

public interface EmpleadoService {
    public abstract List<Empleado> listaEmpleado();
    public abstract Empleado insertaActualizaEmpleado(Empleado obj);
    public abstract void eliminaEmpleado(int idEmpleado);
    public abstract List<Empleado> listaEmpleadoPorNombreYApellidoLike(String nombres, String apellidos);
}

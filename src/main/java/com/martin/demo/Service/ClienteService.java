package com.martin.demo.Service;

import com.martin.demo.Entity.Categoria;
import com.martin.demo.Entity.Cliente;

import java.util.List;

public interface ClienteService {
    public abstract List<Cliente> listaCliente();
    public abstract Cliente insertaActualizaCliente(Cliente obj);
    public abstract void eliminaCliente(int idCliente);
    public abstract List<Cliente> listaClientePorNombreLike(String nombres);
}

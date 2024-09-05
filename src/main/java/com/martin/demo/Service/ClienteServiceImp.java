package com.martin.demo.Service;

import com.martin.demo.Entity.Cliente;
import com.martin.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listaCliente() {
        return repository.findAll();
    }

    @Override
    public Cliente insertaActualizaCliente(Cliente obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaCliente(int idCliente) {
        repository.deleteById(idCliente);
    }

    @Override
    public List<Cliente> listaClientePorNombreLike(String nombres) {
        return repository.listaPorNombreLike(nombres);
    }
}

package com.orden.compra.demo.com.servicios;


import com.orden.compra.demo.com.modelo.Cliente;
import com.orden.compra.demo.com.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImp implements ClienteServicio  {

    @Autowired
    private ClienteRepositorio repository;


    @Override
    @Transactional(readOnly=true)
    public List<Cliente> listar() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> porId(Long id) {
        return repository.findById(id);
    }
    @Override
    @Transactional
    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }
    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }



}

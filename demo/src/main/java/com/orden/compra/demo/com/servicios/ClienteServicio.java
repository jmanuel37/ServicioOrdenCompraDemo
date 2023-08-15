package com.orden.compra.demo.com.servicios;

import com.orden.compra.demo.com.modelo.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteServicio {
    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    Cliente guardar(Cliente cliente);
    void eliminar(Long id);
}

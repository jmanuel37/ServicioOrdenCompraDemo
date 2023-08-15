package com.orden.compra.demo.com.repositorio;

import com.orden.compra.demo.com.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}

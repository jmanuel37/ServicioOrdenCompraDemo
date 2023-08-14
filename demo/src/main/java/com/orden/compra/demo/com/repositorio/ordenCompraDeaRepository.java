package com.orden.compra.demo.com.repositorio;


import com.orden.compra.demo.com.modelo.OrdenCompraDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ordenCompraDeaRepository extends JpaRepository<OrdenCompraDetalle, Long> {
}

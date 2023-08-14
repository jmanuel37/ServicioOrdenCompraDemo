package com.orden.compra.demo.com.repositorio;

import com.orden.compra.demo.com.modelo.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ordenCompraRepository extends JpaRepository<OrdenCompra, Long>{
}

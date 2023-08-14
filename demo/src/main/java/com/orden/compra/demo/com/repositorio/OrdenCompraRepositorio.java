package com.orden.compra.demo.com.repositorio;

import com.orden.compra.demo.com.modelo.OrdenCompra;

import java.util.List;

public interface OrdenCompraRepositorio {

    List<OrdenCompra> buscarOrdenCompras();
    void insertar(OrdenCompra ordenCompra);
}

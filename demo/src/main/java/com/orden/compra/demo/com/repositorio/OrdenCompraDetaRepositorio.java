package com.orden.compra.demo.com.repositorio;

import com.orden.compra.demo.com.modelo.OrdenCompraDetalle;

import java.util.List;

public interface OrdenCompraDetaRepositorio {
    List<OrdenCompraDetalle> buscarOrdenDetaCompras();
    void insertarDeta(OrdenCompraDetalle ordenCompra);
}

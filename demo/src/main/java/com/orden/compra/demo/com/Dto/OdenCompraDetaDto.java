package com.orden.compra.demo.com.Dto;

import com.orden.compra.demo.com.modelo.Producto;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class OdenCompraDetaDto {
    private long ordenPedidoId;
    private int orderDetaId;

    private String nombreProd;

    //private BigDecimal precioProd;

    //private long producto;
    private String descProd;
    private Long idProducto;
    private int cantProducto;
    private BigDecimal precioProducto;

    public long getOrdenPedidoId() {
        return ordenPedidoId;
    }

    public void setOrdenPedidoId(long ordenPedidoId) {
        this.ordenPedidoId = ordenPedidoId;
    }

    public int getOrderDetaId() {
        return orderDetaId;
    }

    public void setOrderDetaId(int orderDetaId) {
        this.orderDetaId = orderDetaId;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }



    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }
}

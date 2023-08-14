package com.orden.compra.demo.com.Dto;

import com.orden.compra.demo.com.modelo.Cliente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenCompraDto {

    private long idOrdCompra;
    private Long idCliente;
    //private String description;
    private Date fecha;
    private BigDecimal precioTotal;

    private List<OdenCompraDetaDto> detalle;

    public OrdenCompraDto(){
        detalle= new ArrayList<OdenCompraDetaDto>();

    }

    public long getIdOrdCompra() {
        return idOrdCompra;
    }

    public void setIdOrdCompra(long idOrdCompra) {
        this.idOrdCompra = idOrdCompra;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<OdenCompraDetaDto> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<OdenCompraDetaDto> detalle) {
        this.detalle = detalle;
    }
}

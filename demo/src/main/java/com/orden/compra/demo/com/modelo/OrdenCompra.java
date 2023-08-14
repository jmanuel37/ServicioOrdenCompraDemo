package com.orden.compra.demo.com.modelo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
//@Table(name = "orden_compra")
public class OrdenCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long facturaId;
    private Long ordenId;

    @Temporal(jakarta.persistence.TemporalType.DATE)
    //private Date fechaFactura;
    private Date fechaOrden;

    @OneToMany(mappedBy = "ordencompra")
    private List<OrdenCompraDetalle> detalle;

    public OrdenCompra() {
        detalle= new ArrayList<OrdenCompraDetalle>();
    }

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" + "ordenId=" + ordenId + ", fechaOrden=" + fechaOrden + ", clienteId=" + clienteId + ", precioTotal=" + precioTotal +", detalle=" + detalle + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.ordenId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdenCompra other = (OrdenCompra) obj;
        return Objects.equals(this.ordenId, other.ordenId);
    }

    public List<OrdenCompraDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<OrdenCompraDetalle> detalle) {
        this.detalle = detalle;
    }



    private Long clienteId;
    //private String description;
    private BigDecimal precioTotal;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

}

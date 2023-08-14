package com.orden.compra.demo.com.modelo;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "orden_compra_detalle")
public class OrdenCompraDetalle  implements Serializable {

    @EmbeddedId
    private OrdenDetallePK ordenDetallePK;

    @MapsId("ordenId")
    @ManyToOne
    //@ManyToOne(cascade = CascadeType.MERGE)
    private OrdenCompra ordencompra;

    private String descripcion;

    public OrdenCompraDetalle() {

    }

    public OrdenCompraDetalle(long ordenId, int detaId) {
        ordenDetallePK = new OrdenDetallePK(ordenId, detaId);
    }

    public OrdenCompra getOrdencompra() {
        return ordencompra;
    }

    public void setOrdencompra(OrdenCompra ordencompra) {
        this.ordencompra = ordencompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /*
    private String nombreProd;
    private BigDecimal precioProd;

    private Long producto;
    */

    public OrdenDetallePK getOrdenDetallePK() {
        return ordenDetallePK;
    }

    public void setOrdenDetallePK(OrdenDetallePK ordenDetallePK) {
        this.ordenDetallePK = ordenDetallePK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.ordenDetallePK);
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
        final OrdenCompraDetalle other = (OrdenCompraDetalle) obj;
        return Objects.equals(this.ordenDetallePK, other.ordenDetallePK);
    }
    @Override
    public String toString() {
        return "OrdenCompraDetalle{" + "ordenDetallePK=" + ordenDetallePK + ",  descripcion=" + descripcion + ",  nombreProd=" + nombreProd +",  productoId=" + productoId +",  cantProducto=" + cantProducto +",  precioProd=" + precioProd +'}';
    }
    private String nombreProd;
    private BigDecimal precioProd;
    private Long productoId;
    private int cantProducto;

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public BigDecimal getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(BigDecimal precioProd) {
        this.precioProd = precioProd;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }
}

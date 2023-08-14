package com.orden.compra.demo.com.modelo;
import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Long idProducto;
    @Basic(optional = false)

    @Column(name = "nombre_prod")
    private String nombreProd;

    @Column(name = "precio_prod")
    private BigDecimal precioProd;

    @Column(name = "uni_medida_prod")
    private String uniMedidaProd;

    @Column(name = "descripcion_prod")
    private String descripcionProd;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

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

    public String getUniMedidaProd() {
        return uniMedidaProd;
    }

    public void setUniMedidaProd(String uniMedidaProd) {
        this.uniMedidaProd = uniMedidaProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public Producto(Long idProducto, String nombreProd, BigDecimal precioProd, String uniMedidaProd, String descripcionProd) {
        this.idProducto = idProducto;
        this.nombreProd = nombreProd;
        this.precioProd = precioProd;
        this.uniMedidaProd = uniMedidaProd;
        this.descripcionProd = descripcionProd;
    }

    public Producto() {
    }
}

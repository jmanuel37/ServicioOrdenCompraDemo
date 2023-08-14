package com.orden.compra.demo.com.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic(optional = false)

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "descripcion_cliente")
    private String descripcionCliente;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombreCliente, String descripcionCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.descripcionCliente = descripcionCliente;
    }

}

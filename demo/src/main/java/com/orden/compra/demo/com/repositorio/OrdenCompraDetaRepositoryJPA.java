package com.orden.compra.demo.com.repositorio;

import com.orden.compra.demo.com.modelo.OrdenCompraDetalle;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrdenCompraDetaRepositoryJPA implements OrdenCompraDetaRepositorio{

    @PersistenceContext
    EntityManager em;
    @Override
    public List<OrdenCompraDetalle> buscarOrdenDetaCompras() {
        TypedQuery<OrdenCompraDetalle> consulta= em.createQuery("select p from OrdenCompraDetalle p",OrdenCompraDetalle.class);
        return consulta.getResultList();
    }

    @Transactional
    public void insertarDeta(OrdenCompraDetalle ordenCompraDt) {
        em.persist(ordenCompraDt);
    }
}

package com.orden.compra.demo.com.repositorio;
import java.util.List;

import com.orden.compra.demo.com.modelo.OrdenCompra;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class OrdenCompraRepositoryJPA implements OrdenCompraRepositorio {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<OrdenCompra> buscarOrdenCompras() {
        TypedQuery<OrdenCompra> consulta= em.createQuery("select p from OrdenCompra p",OrdenCompra.class);
        return consulta.getResultList();
    }

    @Transactional
    public void insertar(OrdenCompra ordenCompra) {
        em.persist(ordenCompra);
    }

}


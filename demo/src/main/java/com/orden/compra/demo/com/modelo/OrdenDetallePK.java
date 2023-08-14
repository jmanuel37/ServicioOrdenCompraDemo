package com.orden.compra.demo.com.modelo;
import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class OrdenDetallePK implements Serializable{

    private long ordenId;
    private int detaId;

    public OrdenDetallePK() {
    }

    public OrdenDetallePK(long ordenId, int detaId) {
        this.ordenId = ordenId;
        this.detaId = detaId;
    }

    public long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(long ordenId) {
        this.ordenId = ordenId;
    }

    public int getDetaId() {
        return detaId;
    }

    public void setDetaId(int detaId) {
        this.detaId = detaId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.ordenId ^ (this.ordenId >>> 32));
        hash = 59 * hash + this.detaId;
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
        final OrdenDetallePK other = (OrdenDetallePK) obj;
        if (this.ordenId != other.ordenId) {
            return false;
        }
        return this.detaId == other.detaId;
    }

    @Override
    public String toString() {
        return "OrdenDetallePK{" + "ordenId=" + ordenId + ", detaId=" + detaId + '}';
    }
}

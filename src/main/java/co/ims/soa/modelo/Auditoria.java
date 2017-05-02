/*
 * Copyright (C) 2017 Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 1.0):
 *  <lhh9499@gmail.com> wrote this file. As long as you retain this notice you
 *  can do whatever you want with this stuff. If we meet some day, and you think
 *  this stuff is worth it, you can buy me a beer in return
 *  ----------------------------------------------------------------------------
 */

package co.ims.soa.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 29/04/2017
 */
@Entity
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 4L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAuditoria")
    private Integer idAuditoria;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fechaCambio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCambio;
    @Column(name = "fechaCaducidad")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCaducidad;
    @Column(name = "estado")
    private Boolean estado;
    
    public Auditoria(){}
    
    public Auditoria(String usuario, Date fechaCambio, Date fechaCaducidad, Boolean estado){
        this.usuario = usuario;
        this.fechaCambio = fechaCambio;
        this.fechaCaducidad = fechaCaducidad;
        this.estado = estado;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

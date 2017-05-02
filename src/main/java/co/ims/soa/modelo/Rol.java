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
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 29/04/2017
 */
@Entity
public class Rol implements Serializable {
    private static final long serialVersionUID = 3L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;
    @Column(name = "descRol")
    private String descRol;
    
    @JoinTable(name = "usuario", joinColumns = {
        @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario")
    private Collection<Usuario> usuarioRolCollection;
    
    public Rol(){}
    
    public Rol(String descRol){
        this.descRol = descRol;
    }

    public String getDescRol() {
        return descRol;
    }

    public void setDescRol(String descRol) {
        this.descRol = descRol;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioRolCollection() {
        return usuarioRolCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioRolCollection) {
        this.usuarioRolCollection = usuarioRolCollection;
    }

    
}

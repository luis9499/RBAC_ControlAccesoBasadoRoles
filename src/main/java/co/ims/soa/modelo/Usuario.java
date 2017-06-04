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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 29/04/2017
 */
@Entity
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 2L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Column(name = "login")
    private String login;
    @Column(name = "pass")
    private String pass;
    
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    
    @JoinTable(name = "usuario_rol", 
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_rol"))    
    private List<Rol> roles;
    
    public Usuario(){}
    
    public Usuario(Persona p, String login, String pass){
        this.persona = p;
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
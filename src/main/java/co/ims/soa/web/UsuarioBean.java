/* 
 * Copyright (C) 2017 Luis Hurtado <lhh9499@gmail.com> 
 * ---------------------------------------------------------------------------- 
 * "THE BEER-WARE LICENSE" (Revision 1.0): 
 *  <lhh9499@gmail.com> wrote this file. As long as you retain this notice you 
 *  can do whatever you want with this stuff. If we meet some day, and you think 
 *  this stuff is worth it, you can buy me a beer in return 
 *  ---------------------------------------------------------------------------- 
 */ 
 
package co.ims.soa.web;

import co.ims.soa.ejbs.UsuarioEJB;
import co.ims.soa.modelo.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 4/06/2017
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    @Inject UsuarioEJB usuarioEJB;
    
    private List<Usuario> usuarios;
    private Usuario usuario;
    
    public UsuarioBean(){}
    
    @PostConstruct
    public void init(){
        usuarios = usuarioEJB.buscarUsuarios();
        usuario = new Usuario(null, null, null);
    }
    
    public String guardarUsuario(){
        System.out.println("guardar usuario...");
        usuarioEJB.agregar(usuario);
        init();
        return null;
    }
    
    public String buscarUsuario(){
        System.out.println("buscar usuario...");
        System.out.println(usuario.getIdUsuario());
        return null;
    }
    
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    public void setusuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}

/*
 * Copyright (C) 2017 Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 1.0):
 *  <lhh9499@gmail.com> wrote this file. As long as you retain this notice you
 *  can do whatever you want with this stuff. If we meet some day, and you think
 *  this stuff is worth it, you can buy me a beer in return
 *  ----------------------------------------------------------------------------
 */

package co.ims.soa.ejbs;

import co.ims.soa.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 30/04/2017
 */
@Stateless
@Path("/usuario")
public class UsuarioEJB {
    @PersistenceContext(unitName="co.ims.soa_rbac_war_1.0-SNAPSHOTPU")
    protected EntityManager em;
    private Object Renponse;
    
    @GET
    @Path("{idUsuario}")
    @Produces("application/json")
    public Usuario buscar(@PathParam("idUsuario") Integer usIdUsuario){
        return em.find(Usuario.class, usIdUsuario);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Usuario agregar(Usuario u){
        em.persist(u);
        em.flush();
        return u;
    }
    
    @DELETE
    @Path("idUsuario")
    @Produces("application/json")
    public Response eliminarUsuario(@PathParam("idUsuario")Integer uIdUsuario){
        Usuario us = em.find(Usuario.class, uIdUsuario);
        if(us!=null){
        em.remove(us);
        }
        return Response.noContent().build();
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Usuario actualizarUsuario(Usuario u){
        em.merge(u);
        return u;
    }
    
    @GET
    @Produces("application/json")
    public List<Usuario> buscarUsuarios(){
        String jpql = "SELECT usua FROM Usuario usua";
        TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
        List<Usuario> resultado = q.getResultList();
        return resultado;
    }
    
}

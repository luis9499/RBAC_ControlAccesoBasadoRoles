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

import co.ims.soa.modelo.Persona;
import co.ims.soa.modelo.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Path("/persona")
public class PersonaEJB {

    @PersistenceContext(unitName = "co.ims.soa_rbac_war_1.0-SNAPSHOTPU")
    protected EntityManager em;
    
    @Inject UsuarioEJB usuarioEJB;
    
    public void crearUsuario(Persona p, String login, String pass){
        Usuario u = new Usuario(p, login, pass);
        usuarioEJB.agregar(u);
    }

    @GET
    @Path("{idPersona}")
    @Produces("application/json")
    public Persona buscar(@PathParam("idPersona") Integer perIdPersona) {
        
        return em.find(Persona.class, perIdPersona);
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Persona agregar(Persona p) {
        em.persist(p);
        em.flush();
        
        return p;
    }

    @DELETE
    @Path("{idPersona}")
    @Produces("application/json")
    public Response eliminar(@PathParam("idPersona") Integer perIdPersona) {
        Persona p = em.find(Persona.class, perIdPersona);
        if (p != null) {
            em.remove(p);
            }   
        return Response.noContent().build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Persona actualizar(Persona p) {
        em.merge(p);
        return p;
    }
    
    @GET
    @Produces("application/json")       
    public List<Persona> buscarTodos(){                
        String jpql = "SELECT per FROM Persona per";
        TypedQuery<Persona> q = em.createQuery(jpql, Persona.class);
        List<Persona> resultado = q.getResultList();
        return resultado;
}
}
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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 30/04/2017
 */
@Stateless
@Path("/persona")
public class PersonaEJB {
    @PersistenceContext(unitName="co.ims.soa_rbac_war_1.0-SNAPSHOTPU")
    protected EntityManager em;
    
    @GET
    @Path("idPersona")
    @Produces("application/json")
    public Persona buscar(@PathParam("idPersona") Integer perIdPersona){
        return em.find(Persona.class, perIdPersona);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Persona agregar(Persona entity){
        em.persist(entity);
        em.flush();
        return entity;
    }
}

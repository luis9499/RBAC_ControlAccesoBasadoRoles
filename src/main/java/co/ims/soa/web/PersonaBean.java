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

import co.ims.soa.ejbs.PersonaEJB;
import co.ims.soa.modelo.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 29/05/2017
 */
@ManagedBean
@SessionScoped
public class PersonaBean {

    @Inject PersonaEJB personaEJB;

    private List<Persona> personas;
    private Persona persona;

    public PersonaBean() {
    }

    @PostConstruct
    public void init() {
        personas = personaEJB.buscarTodos();
        persona = new Persona();
    }

    public String guardar() {
        System.out.println("guardar...");
        personaEJB.agregar(persona);
        init();
        return null;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

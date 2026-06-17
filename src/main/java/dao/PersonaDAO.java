package dao;

import entities.Persona;
import jakarta.persistence.EntityManager;

public class PersonaDAO {

    private EntityManager em;

    public PersonaDAO(EntityManager em){
        this.em = em;
    }

    public void save(Persona persona){
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona getById(Long id){
        return em.find(Persona.class,id);
    }

    public void delete(Long id){
        Persona persona = getById(id);

        if (persona != null){
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
        }
    }
}

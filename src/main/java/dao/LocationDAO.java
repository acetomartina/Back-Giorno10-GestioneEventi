package dao;

import entities.Location;
import jakarta.persistence.EntityManager;

public class LocationDAO {

    private EntityManager em;

    public LocationDAO(EntityManager em){
        this.em = em;
    }

    public void save(Location location){
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location getById(Long id) {
        return em.find(Location.class,id);
    }

    public void delete(Long id){
        Location location = getById(id);

        if (location != null){
            em.getTransaction().begin();
            em.remove(location);
            em.getTransaction().commit();
        }
    }
}

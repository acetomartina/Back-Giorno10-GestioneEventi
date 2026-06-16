package dao;

import entities.Evento;
import jakarta.persistence.EntityManager;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    // salvo l'evento
    public void save(Evento evento) {
        // apro la transazione
        em.getTransaction().begin();
        // salvo
        em.persist(evento);
        // confermo la modifica nel DB
        em.getTransaction().commit();
    }


    public Evento getById(Long id) {
        // legge soltanto, quindi non serve transazione
        // .class perché dobbiamo cercare nella tabella Evento (classe=tabella)
        return em.find(Evento.class, id);
    }

    public void delete(Long id) {
        // se esiste lo trova (vedi metodo getById), sennò null
        Evento evento = getById(id);
        // se non è null inizia la transazione come in save
        if (evento != null) {
            em.getTransaction().begin();
            // rimuovo l'evento
            em.remove(evento);
            // confermo la modifica
            em.getTransaction().commit();
        }

    }
}



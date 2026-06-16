package acetomartina;


import dao.EventoDAO;
import entities.Evento;
import entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");

        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento1 = new Evento(
                "Concerto Ligabue",
                LocalDate.of(2026, 7, 20),
                "Grande concerto allo stadio",
                TipoEvento.PUBBLICO,
                50000
        );

        Evento evento2 = new Evento(
                "Lucca Comics & Games",
                LocalDate.of(2026, 10, 31),
                "Festival dedicato a fumetti, giochi e cosplay",
                TipoEvento.PUBBLICO,
                80000
        );

        Evento evento3 = new Evento(
                "Escursione in Sila",
                LocalDate.of(2026, 8, 15),
                "Trekking guidato nel Parco Nazionale della Sila",
                TipoEvento.PUBBLICO,
                40
        );

        Evento evento4 = new Evento(
                "Comicon Napoli",
                LocalDate.of(2026, 5, 1),
                "Fiera dedicata a manga, anime e videogiochi",
                TipoEvento.PUBBLICO,
                60000
        );

        Evento evento5 = new Evento(
                "Escursione alle Cascate del Maesano",
                LocalDate.of(2026, 9, 10),
                "Percorso naturalistico con guida",
                TipoEvento.PRIVATO,
                25
        );

        eventoDAO.save(evento1);
        eventoDAO.save(evento2);
        eventoDAO.save(evento3);
        eventoDAO.save(evento4);
        eventoDAO.save(evento5);

        Evento eventoTrovato = eventoDAO.getById(3L);
        System.out.println(eventoTrovato);

        eventoDAO.delete(4L);

    }
}


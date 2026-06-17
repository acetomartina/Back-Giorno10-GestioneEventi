package acetomartina;


import dao.EventoDAO;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");

        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        Location location1 = new Location(
                "Stadio Olimpico",
                "Roma"
        );

        Location location2 = new Location(
                "Lucca Fiere",
                "Lucca"
        );

        Location location3 = new Location(
                "Parco Nazionale della Sila",
                "Camigliatello Silano"
        );

        Location location4 = new Location(
                "Mostra d'Oltremare",
                "Napoli"
        );

        Location location5 = new Location(
                "Cascate del Maesano",
                "Santo Stefano in Aspromonte"
        );

        Location location6 = new Location(
                "Palacultura",
                "Messina"
        );

        locationDAO.save(location1);
        locationDAO.save(location2);
        locationDAO.save(location3);
        locationDAO.save(location4);
        locationDAO.save(location5);
        locationDAO.save(location6);

        Evento evento1 = new Evento(
                "Concerto Ligabue",
                LocalDate.of(2026, 7, 20),
                "Grande concerto allo stadio",
                TipoEvento.PUBBLICO,
                50000,
                location1
        );

        Evento evento2 = new Evento(
                "Lucca Comics & Games",
                LocalDate.of(2026, 10, 31),
                "Festival dedicato a fumetti, giochi e cosplay",
                TipoEvento.PUBBLICO,
                80000,
                location2
        );

        Evento evento3 = new Evento(
                "Escursione in Sila",
                LocalDate.of(2026, 8, 15),
                "Trekking guidato nel Parco Nazionale della Sila",
                TipoEvento.PUBBLICO,
                40,
                location3
        );

        Evento evento4 = new Evento(
                "Comicon Napoli",
                LocalDate.of(2026, 5, 1),
                "Fiera dedicata a manga, anime e videogiochi",
                TipoEvento.PUBBLICO,
                60000,
                location4
        );

        Evento evento5 = new Evento(
                "Escursione alle Cascate del Maesano",
                LocalDate.of(2026, 9, 10),
                "Percorso naturalistico con guida",
                TipoEvento.PRIVATO,
                25,
                location5
        );

        eventoDAO.save(evento1);
        eventoDAO.save(evento2);
        eventoDAO.save(evento3);
        eventoDAO.save(evento4);
        eventoDAO.save(evento5);

        Persona persona1 = new Persona(
                "Martina",
                "Aceto",
                "martina@email.it",
                LocalDate.of(1998, 5, 10),
                Sesso.F
        );

        personaDAO.save(persona1);

        Partecipazione partecipazione1 = new Partecipazione(
                persona1,
                evento1,
                StatoPartecipazione.CONFERMATA
        );

        partecipazioneDAO.save(partecipazione1);

    }
}


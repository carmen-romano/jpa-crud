package carmenromano.dao;

import carmenromano.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventDao {
    private final EntityManager entity_manager; //è utilizzata per gestire
    // le operazioni di persistenza (creare, leggere, cancellare) nell applicazione JPA
    // e consente l'interazione con il database

    public EventDao(EntityManager entity_manager) {
        this.entity_manager = entity_manager;
    }

    //metodo per salvare i dati nel DB
    public void save(Event event){
    //per poter far funzionare questo metodo abbiamo bisogno di 4 passaggi:
    //1)Creare una nuova transazione
        EntityTransaction transazione = entity_manager.getTransaction(); // EntityTransaction permette di gestire le transazioni
        // cioè gruppi di operazioni sul database che devono essere eseguite insieme. Se una di queste operazioni fallisce,
        // tutte le altre vengono annullate per mantenere il database in uno stato coerente e corretto.
    // 2)Inizio transazione
        transazione.begin();
    // 3)Qui stiamo dicendo a JPA di aggiungere l'oggetto event al persist context.
        entity_manager.persist(event);
        // Questo significa che JPA ora tiene traccia di questo oggetto e sa che dovrà
        // salvarlo nel database(in questo momento non è ancora salvato).
    // 4) In questo momento concludiamo la transazione e di conseguenza salviamo l oggetto nel database

        transazione.commit();
        System.out.println("L'elemento" + event.getTitolo() + "è stato correttamente salvato nel database");
    }
}

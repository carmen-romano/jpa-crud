package carmenromano;

import carmenromano.dao.EventDao;
import carmenromano.entities.Event;
import carmenromano.enums.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Application {
    //questo metodo ci consente di creare oggetti entity manager per poter interagire con il db
    private static final EntityManagerFactory entity_final = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager entity_manager = entity_final.createEntityManager();
        EventDao sd = new EventDao(entity_manager);

        System.out.println("*******************SAVE********************");

        Event event1 = new Event("Evento 1", LocalDate.parse("2024/04/02", DateTimeFormatter.ofPattern("yyyy/MM/dd")) ,
        "prova database", EventType.PRIVATO,3);
        Event event2 = new Event("Evento 2", LocalDate.parse("2024/06/02", DateTimeFormatter.ofPattern("yyyy/MM/dd")) ,
        "prova database2", EventType.PRIVATO,5);
        Event event3 = new Event("Evento 3", LocalDate.parse("2022/02/02", DateTimeFormatter.ofPattern("yyyy/MM/dd")) ,
        "prova database3", EventType.PUBBLICO,8);

       // sd.save(event1);
       // sd.save(event2);
       // sd.save(event3);
        System.out.println("*******************GET BY ID********************");



    }
}

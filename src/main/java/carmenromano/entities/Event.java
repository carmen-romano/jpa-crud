package carmenromano.entities;

import carmenromano.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity  //per identificare la classe che sarà mappata nella tabella db
@Table(name = "eventi") //nome tabella
public class Event {

    @Id //identificare chiave primaria nella tabella
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Per far generare automaticamente l id
    private long id; // per avere come id dei numeri seriali

    @Column(name = "titolo") //nome colonna
    private String titolo;

    @Column(name = "data_evento") //nome colonna
    private LocalDate data_evento;

    @Column(name = "descrizione") //nome colonna
    private String descrizione;

    @Column(name = "tipo_evento") //nome colonna
    @Enumerated(EnumType.STRING) // Definisce che il valore dell'enum sarà salvato come STRING
    private EventType eventType;

    @Column(name = "numero_max_partecipanti") //nome colonna
    private Integer numero_max_partecipanti;

    // Costruttore di default richiesto da JPA
    public Event() {}

    public Event(String titolo, LocalDate data_evento, String descrizione, EventType eventType, Integer numero_max_partecipanti) {
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.eventType = eventType;
        this.numero_max_partecipanti = numero_max_partecipanti;
    }

    // Getter e Setter
    public long getId() {
        return id;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Integer getNumero_max_partecipanti() {
        return numero_max_partecipanti;
    }

    public void setNumero_max_partecipanti(Integer numero_max_partecipanti) {
        this.numero_max_partecipanti = numero_max_partecipanti;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", eventType=" + eventType +
                ", numero_max_partecipanti=" + numero_max_partecipanti +
                '}';
    }
}

package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    private List<Event> listEvents = new LinkedList<>();
    List<Event> agenda = new LinkedList<>();
    
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        agenda.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO : implémenter cette méthode
        List eventsInDay = new LinkedList<>();
        for (Event event : agenda) {
            if (event.isInDay(day))
                eventsInDay.add(event);
        }
        return eventsInDay;
        
    }
    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> eventsInAgenda = new LinkedList<>();
        for (Event e : listEvents) {
            if (e.getTitle().equals(title)) {
                eventsInAgenda.add(e);
            }
        }
        return eventsInAgenda;
    }
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        if (listEvents.isEmpty()) {
            return true;
        }
        for (Event event : listEvents) {
            if (!e.getStart().isBefore(event.getStart()) && !e.getStart().isAfter(event.getStart().plus(event.getDuration()))) {
                return false;
            }
        }
        return true;
    }
}
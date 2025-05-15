import java.util.*;

public class EventManager {
    private Map<String, Event> events;

    public EventManager() {
        events = new HashMap<>();
    }

    public void addEvent(Event e) {
        events.put(e.getId(), e);
    }

    public Event getEvent(String id) {
        return events.get(id);
    }

    public Collection<Event> getAllEvents() {
        return events.values();
    }
}

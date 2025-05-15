import java.util.ArrayList;
import java.util.List;

public class Event {
    private String id, name, date, venue, description;
    private double fee;
    private List<Participant> participants;

    public Event(String id, String name, String date, String venue, String description, double fee) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.description = description;
        this.fee = fee;
        this.participants = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getFee() { return fee; }
    public String getDetails() {
        return "<html><b>" + name + "</b><br/>Date: " + date +
                "<br/>Venue: " + venue + "<br/>Fee: ₹" + fee +
                "<br/>Description: " + description + "<br/>Participants: " + participants.size() + "</html>";
    }

    public void addParticipant(Participant p) {
        participants.add(p);
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }
}

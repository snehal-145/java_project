public class Participant {
    private String name;
    private boolean hasPaid;

    public Participant(String name, boolean hasPaid) {
        this.name = name;
        this.hasPaid = hasPaid;
    }

    public String getName() {
        return name;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    @Override
    public String toString() {
        return name + " (Paid: " + (hasPaid ? "Yes" : "No") + ")";
    }
}

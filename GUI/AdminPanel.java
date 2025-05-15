import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JPanel {
    public AdminPanel(MainFrame frame, EventManager manager) {
        setLayout(new BorderLayout());

        JTextArea display = new JTextArea();
        display.setEditable(false);
        JButton addBtn = new JButton("Add Event");
        JButton viewBtn = new JButton("View Participants");
        JButton backBtn = new JButton("Logout");

        JPanel top = new JPanel();
        top.add(addBtn);
        top.add(viewBtn);
        top.add(backBtn);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(display), BorderLayout.CENTER);

        addBtn.addActionListener(e -> {
            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField date = new JTextField();
            JTextField venue = new JTextField();
            JTextField desc = new JTextField();
            JTextField fee = new JTextField();

            Object[] fields = {
                "Event ID:", id,
                "Name:", name,
                "Date:", date,
                "Venue:", venue,
                "Description:", desc,
                "Fee:", fee
            };

            int option = JOptionPane.showConfirmDialog(this, fields, "Add Event", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    Event ev = new Event(
                        id.getText(), name.getText(), date.getText(),
                        venue.getText(), desc.getText(), Double.parseDouble(fee.getText()));
                    manager.addEvent(ev);
                    display.setText("Event added:\n" + ev.getDetails());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        });

        viewBtn.addActionListener(e -> {
            String eid = JOptionPane.showInputDialog(this, "Enter Event ID:");
            Event event = manager.getEvent(eid);
            if (event != null) {
                StringBuilder sb = new StringBuilder("Participants:\n");
                for (Participant p : event.getParticipants()) {
                    sb.append("- ").append(p).append("\n");
                }
                display.setText(sb.toString());
            } else {
                display.setText("Event not found.");
            }
        });

        backBtn.addActionListener(e -> frame.goToLogin());
    }
}

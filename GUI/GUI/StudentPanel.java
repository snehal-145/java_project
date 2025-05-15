import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {
    public StudentPanel(MainFrame frame, EventManager manager) {
        setLayout(new BorderLayout());

        DefaultListModel<Event> eventListModel = new DefaultListModel<>();
        JList<Event> eventList = new JList<>(eventListModel);
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton refreshBtn = new JButton("Refresh Events");
        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");
     
        refreshBtn.setBackground(new Color(0, 123, 255)); 
        refreshBtn.setForeground(Color.WHITE);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 18));
        refreshBtn.setOpaque(true);
        refreshBtn.setBorderPainted(false);

        registerBtn.setBackground(new Color(40, 167, 69));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 18));
        registerBtn.setOpaque(true);
        registerBtn.setBorderPainted(false);

        backBtn.setBackground(new Color(220, 53, 69)); 
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(new Font("Arial", Font.BOLD, 18));
        backBtn.setOpaque(true);
        backBtn.setBorderPainted(false);

        JPanel buttons = new JPanel();
        buttons.add(refreshBtn);
        buttons.add(registerBtn);
        buttons.add(backBtn);

        add(new JScrollPane(eventList), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        refreshBtn.addActionListener(e -> {
            eventListModel.clear();
            for (Event ev : manager.getAllEvents()) {
                eventListModel.addElement(ev);
            }
        });

        registerBtn.addActionListener(e -> {
            Event selected = eventList.getSelectedValue();
            if (selected == null) {
                JOptionPane.showMessageDialog(this, "Select an event first.");
                return;
            }

            JTextField nameField = new JTextField();
            JCheckBox paidCheck = new JCheckBox("Paid");

            Object[] fields = {"Your Name:", nameField, paidCheck};

            int opt = JOptionPane.showConfirmDialog(this, fields, "Register", JOptionPane.OK_CANCEL_OPTION);
            if (opt == JOptionPane.OK_OPTION) {
                Participant p = new Participant(nameField.getText(), paidCheck.isSelected());
                selected.addParticipant(p);
                JOptionPane.showMessageDialog(this, "Registered for " + selected.getName());
            }
        });

        backBtn.addActionListener(e -> frame.goToLogin());
    }
}

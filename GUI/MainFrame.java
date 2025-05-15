import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private EventManager eventManager;

    public MainFrame() {
        setTitle("College Fest Event Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        eventManager = new EventManager();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        LoginPanel loginPanel = new LoginPanel(this, eventManager);
        mainPanel.add(loginPanel, "Login");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");
    }

    public void showAdminPanel() {
        AdminPanel adminPanel = new AdminPanel(this, eventManager);
        mainPanel.add(adminPanel, "Admin");
        cardLayout.show(mainPanel, "Admin");
    }

    public void showStudentPanel() {
        StudentPanel studentPanel = new StudentPanel(this, eventManager);
        mainPanel.add(studentPanel, "Student");
        cardLayout.show(mainPanel, "Student");
    }

    public void goToLogin() {
        cardLayout.show(mainPanel, "Login");
    }
}

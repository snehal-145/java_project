import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
    public LoginPanel(MainFrame frame, EventManager manager) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        JButton loginBtn = new JButton("Admin Login");
        JButton guestBtn = new JButton("Continue as Student");

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(userLabel, gbc);
        gbc.gridx = 1;
        add(userField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(passLabel, gbc);
        gbc.gridx = 1;
        add(passField, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        add(loginBtn, gbc);
        gbc.gridy++;
        add(guestBtn, gbc);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (user.equals("admin") && pass.equals("admin123")) {
                frame.showAdminPanel();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid admin credentials.");
            }
        });

        guestBtn.addActionListener(e -> frame.showStudentPanel());
    }
}

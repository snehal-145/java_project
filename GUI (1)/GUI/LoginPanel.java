import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public LoginPanel(MainFrame frame, EventManager manager) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setBackground(new Color(240, 240, 255)); 
        
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Sans Serif", Font.BOLD, 40));
        title.setForeground(new Color(50, 50, 150));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        userField.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        passField.setFont(new Font("Arial", Font.PLAIN, 20));

    
        JButton loginBtn = new JButton("Admin Login");
        JButton guestBtn = new JButton("Continue as Student");

    
        loginBtn.setBackground(new Color(50, 150, 250));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 18));
       

        guestBtn.setBackground(new Color(50, 200, 150)); 
        guestBtn.setForeground(Color.WHITE);
        guestBtn.setFont(new Font("Arial", Font.BOLD, 18));

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

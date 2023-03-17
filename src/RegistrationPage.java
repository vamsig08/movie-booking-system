import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegistrationPage extends JDialog{
    private JPanel registrationPanel;
    private JTextField nameTF;
    private JTextField phoneTF;
    private JTextField usernameTF;
    private JPasswordField passwordPF;
    private JPasswordField confirmPasswordPF;
    private JButton regBtn;
    private JButton cancelBtn;
    private JTextField emailTF;

    public RegistrationPage(JFrame parent)
    {
        super(parent);
        setTitle("Create a New Account");
        setContentPane(registrationPanel);
        setMinimumSize(new Dimension(500, 475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);

    }

    private void registerUser()
    {
        String name = nameTF.getText();
        String email = emailTF.getText();
        String phone = phoneTF.getText();
        String username = usernameTF.getText();
        String password = String.valueOf(passwordPF.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordPF.getPassword());

        if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!password.equals(confirmPassword))
        {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = addUserToDatabase(name, email, phone, username, password);
        if(user != null)
        {
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Failed to register new user", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public User user;

    private User addUserToDatabase(String name, String email, String phone, String username, String password)
    {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/moviebookingsystemdb";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO UserInfo(name, email, phone, username, password) " + "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);

            //amount of times a row was added
            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0)
            {
                user = new User();
                user.name = name;
                user.email = email;
                user.phone = phone;
                user.username = username;
                user.password = password;
            }

            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args) {
        RegistrationPage registrationPage = new RegistrationPage(null);
        User user = registrationPage.user;
        //feedback to dev
        if(user != null)
        {
            System.out.println("Registration was successful for: " + user.name);
        }
        else
        {
            System.out.println("Registration Canceled");
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPage extends JFrame{
    private JLabel logoMBS;
    private JTextField emailTF;
    private JPasswordField passwordPF;
    private JButton okBtn;
    private JButton cancelBtn;
    private JPanel loginPanel;
    private JButton registerHereButton;


    public LoginPage(JFrame parent)
    {
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(550, 400));

        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        boolean hasRegisteredUsers = hasRegisteredUsers();



        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTF.getText();
                String password = String.valueOf(passwordPF.getPassword());

                user = checkUserInfo(email, password);

                if(user != null)
                {
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(LoginPage.this, "Email or Password is Incorrect", "Failed to Authorize", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        registerHereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationPage registrationPage = new RegistrationPage(LoginPage.this);
                User user = registrationPage.user;

                if(user != null)
                {
                    JOptionPane.showMessageDialog(LoginPage.this, "New User: " + user.name, "Successful Registration", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        if(hasRegisteredUsers)
        {
            setVisible(true);

        }
        else
        {
            dispose();
            RegistrationPage registrationPage = new RegistrationPage(this);
            User user = registrationPage.user;

            if(user != null)
            {
                JOptionPane.showMessageDialog(this, "New User: " + user.name, "Successfully Registered", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public User user;

    private User checkUserInfo(String email, String password)
    {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/moviebookingsystemdb";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM userinfo WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.username = resultSet.getString("address");
                user.password = resultSet.getString("password");
            }

            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return user;
    }

    private boolean hasRegisteredUsers()
    {
        boolean hasRegisteredUsers = false;

        //final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/moviebookingsystemdb";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try
        {
            //connect to mysql server and create db if !exists
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();


            //check if users exist in table
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM UserInfo");

            if(resultSet.next())
            {
                int numUsers = resultSet.getInt(1);
                if(numUsers > 0)
                {
                    hasRegisteredUsers = true;
                }
            }

            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return hasRegisteredUsers;
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage(null);
        User user = loginPage.user;

        //feedback to dev
        if(user != null)
        {
            System.out.println("Successful Login of: " + user.name);
            System.out.println("\tEmail: " + user.email);
            System.out.println("\tPhone: " + user.phone);
            System.out.println("\tUsername: " + user.username);
        }
        else
        {
            System.out.println("User not recognized");
        }
    }
}

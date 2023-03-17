import javax.swing.*;
import java.awt.*;

public class ConfirmationPage extends JDialog {
    private JPanel confirmationPanel;
    private JButton logOutButton;
    public User user;


    public ConfirmationPage(JFrame parent)
    {
        super(parent);
        setTitle("Confirm");
        setContentPane(confirmationPanel);
        setMinimumSize(new Dimension(500, 475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ConfirmationPage confirmationPage = new ConfirmationPage(null);
        User user = confirmationPage.user;
    }
}

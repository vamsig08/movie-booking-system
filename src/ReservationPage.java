import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationPage extends JDialog{
    private JPanel reservationPanel;
    private JTextField ccNameTF;
    private JTextField ccNumTF;
    private JTextField ccSecurityCodeTF;
    private JFormattedTextField ccExpirationTF;
    private JTextField billingAddrTF;
    private JButton BACKButton;
    private JButton CONFIRMButton1;
    private JButton CANCELButton;
    private JTextArea totalPriceTA;
    private JTextArea movieTitleTA;
    private JCheckBox ccInfoCB;
    private JSpinner numOfSeatsComboB;

    public User user;

    public ReservationPage(JFrame parent)
    {
        super(parent);
        setTitle("Reserve");
        setContentPane(reservationPanel);
        setMinimumSize(new Dimension(500, 475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ccInfoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCCInfo();
            }
        });
        setVisible(true);
    }

    //check box to save info
    private void saveCCInfo()
    {
        String name = ccNameTF.getText();
        String ccNum = ccNumTF.getText();
        String ccSecCode = ccSecurityCodeTF.getText();
        String ccExpir = ccExpirationTF.getText();
        String billingAddr = billingAddrTF.getText();

        if(name.isEmpty() || ccNum.isEmpty() || ccSecCode.isEmpty() || ccExpir.isEmpty() || billingAddr.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //save info to db
    }
    //connect to db to store user CC and billing info
    public static void main(String[] args) {
        ReservationPage reservationPage = new ReservationPage(null);
        User user = reservationPage.user;
    }
}

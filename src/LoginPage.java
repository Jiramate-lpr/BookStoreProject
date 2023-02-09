import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame {
    User admin;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JPanel logInPage;
    private JButton btSignIn;

    public LoginPage()
    {
        setContentPane(logInPage);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        admin = new User();
        admin.setAccount("max");
        admin.setPassword("123");

        btSignIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                checkAccount(tfUsername.getText(), pfPassword.getPassword());
            }
        });
    }
    private void checkAccount(String userName, char[] password)
    {
        String userPassword =String.valueOf(password);
        if (userName.equals(admin.getAccount()) && userPassword.equals(admin.getPassword()))
        {
            System.out.println("Success");
            Menu mainMenu = new Menu();
            setVisible(false);
        }
        else
        {
            System.out.println("Fail");
        }
    }
}

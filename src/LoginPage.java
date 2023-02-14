import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame {
    User admin;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JPanel logInPage;
    private JButton btSignIn;
    private JLabel usernameIncorrect;
    private JLabel passwordIncorrect;

    public LoginPage()
    {
        setContentPane(logInPage);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        usernameIncorrect.setVisible(false);
        passwordIncorrect.setVisible(false);

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

        tfUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                usernameIncorrect.setVisible(false);
                passwordIncorrect.setVisible(false);
            }
        });

        pfPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                usernameIncorrect.setVisible(false);
                passwordIncorrect.setVisible(false);
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
        else if (!userName.equals(admin.getAccount()))
        {
            System.out.println("Fail");
            usernameIncorrect.setVisible(true);
        }
        else if (!userPassword.equals(admin.getPassword()))
        {
            System.out.println("Fail");
            passwordIncorrect.setVisible(true);
        }
        else
        {
            System.out.println("Fail");
            usernameIncorrect.setVisible(true);
            passwordIncorrect.setVisible(true);
        }
    }
}

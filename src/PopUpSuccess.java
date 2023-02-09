import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpSuccess extends JFrame {
    private JPanel puSuccess;
    private JButton closeButton;

    public PopUpSuccess()
    {
        setContentPane(puSuccess);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
            }
        });
    }
}

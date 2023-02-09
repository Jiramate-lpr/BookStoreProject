import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PurchaseFailed extends JFrame {
    private JButton btOk;
    private JPanel pnFailed;

    public PurchaseFailed()
    {
        setContentPane(pnFailed);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        btOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
            }
        });
    }
}

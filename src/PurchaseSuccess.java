import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PurchaseSuccess extends JFrame {
    private JPanel pnSuccess;
    private JButton btCheckOrder;
    private JButton btClose;

    public PurchaseSuccess()
    {
        setContentPane(pnSuccess);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        btClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
            }
        });
        btCheckOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PurchaseHistory history = new PurchaseHistory();
            }
        });
    }
}

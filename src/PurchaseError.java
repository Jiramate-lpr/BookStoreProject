import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PurchaseError extends JFrame{
    private JButton btOk;
    private JPanel pnError;
    public PurchaseError()
    {
        setContentPane(pnError);
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

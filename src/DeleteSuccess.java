import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteSuccess extends JFrame {
    private JPanel pnDeleteSuccess;
    private JButton btOK;

    public DeleteSuccess()
    {
        setContentPane(pnDeleteSuccess);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
        btOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
            }
        });
    }
}

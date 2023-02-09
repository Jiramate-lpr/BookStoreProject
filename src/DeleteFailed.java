import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteFailed extends JFrame {
    private JButton btOK;
    private JPanel pnDeleteFailed;

    public DeleteFailed()
    {
        setContentPane(pnDeleteFailed);
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

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OverVolume extends JFrame {
    private JPanel pnOverVolume;
    private JButton btOk;

    public OverVolume()
    {
        setContentPane(pnOverVolume);
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

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {
    private JPanel menuPage;
    private JButton btAdd;
    private JButton btDelete;
    private JButton btView;
    private JButton btBuy;


    public Menu()
    {
        setContentPane(menuPage);
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AddBook addBookPage = new AddBook();
            }
        });
        btView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BookTable viewBook = new BookTable();
            }
        });
        btDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DeleteBook deletePage = new DeleteBook();
            }
        });

        btBuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PurchasePage purchasePage = new PurchasePage();
            }
        });
    }
}

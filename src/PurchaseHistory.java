import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class PurchaseHistory extends JFrame {
    private JTable tbPurchase;
    private JPanel pnPurchaseHistory;
    Font f=new Font("TH Sarabun New", Font.PLAIN, 20);

    public PurchaseHistory() {
        OrderedBooks orderedBookTable = new OrderedBooks();
        tbPurchase.setModel(orderedBookTable);
        tbPurchase.setModel(orderedBookTable);
        tbPurchase.setLocale(new Locale("th", "TH"));
        tbPurchase.setFont(f);
        setContentPane(pnPurchaseHistory);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

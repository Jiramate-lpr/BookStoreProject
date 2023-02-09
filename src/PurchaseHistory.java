import javax.swing.*;

public class PurchaseHistory extends JFrame {
    private JTable tbPurchase;
    private JPanel pnPurchaseHistory;

    public PurchaseHistory() {
        OrderedBooks orderedBookTable = new OrderedBooks();
        tbPurchase.setModel(orderedBookTable);
        setContentPane(pnPurchaseHistory);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

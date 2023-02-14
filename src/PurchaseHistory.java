import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Locale;

public class PurchaseHistory extends JFrame {
    private JTable tbPurchase;
    private JPanel pnPurchaseHistory;
    Font f=new Font("TH Sarabun New", Font.PLAIN, 20);

    public PurchaseHistory() {
        setDisplay();
    }
    private void setLayoutTable()
    {
        TableColumnModel columnModel = tbPurchase.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(70);
        columnModel.getColumn(2).setPreferredWidth(250);
        columnModel.getColumn(3).setPreferredWidth(2000);
        columnModel.getColumn(4).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(50);
    }

    private void setDisplay()
    {
        OrderedBooks orderedBookTable = new OrderedBooks();
        tbPurchase.setModel(orderedBookTable);
        tbPurchase.setLocale(new Locale("th", "TH"));
        tbPurchase.setFont(f);
        tbPurchase.setRowHeight(40);
        setLayoutTable();
        setContentPane(pnPurchaseHistory);
        setVisible(true);
        setSize(1920,1040);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

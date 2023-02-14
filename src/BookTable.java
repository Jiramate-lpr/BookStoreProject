import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.util.Locale;

public class BookTable extends JFrame  {
    private JTable tbBook;
    private JPanel pnTable;
    Font f=new Font("TH Sarabun New", Font.PLAIN, 20);


    public BookTable() {
        setDisplay();
    }
    private void setLayoutTable()
    {
        TableColumnModel columnModel = tbBook.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(70);
        columnModel.getColumn(2).setPreferredWidth(250);
        columnModel.getColumn(3).setPreferredWidth(2000);
        columnModel.getColumn(4).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(50);
    }
    private void setDisplay()
    {
        FinalBookTable finalBookTable = new FinalBookTable();
        tbBook.setModel(finalBookTable);
        tbBook.setLocale(new Locale("th", "TH"));
        tbBook.setFont(f);
        tbBook.setRowHeight(40);
        setContentPane(pnTable);
        setLayoutTable();
        setVisible(true);
        setSize(1920,1040);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
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
        FinalBookTable finalBookTable = new FinalBookTable();
        tbBook.setModel(finalBookTable);
        tbBook.setLocale(new Locale("th", "TH"));
        tbBook.setFont(f);
        tbBook.setRowHeight(40);
        setContentPane(pnTable);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

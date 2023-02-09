import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

public class BookTable extends JFrame  {
    private JTable tbBook;
    private JPanel pnTable;


    public BookTable() {
        FinalBookTable finalBookTable = new FinalBookTable();
        tbBook.setModel(finalBookTable);
        setContentPane(pnTable);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

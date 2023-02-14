import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

public class DeleteBook extends JFrame{
    private JTextField tfBookCode;
    private JPanel deletePage;
    private JButton btDelete;
    private JTable tbBooks;
    Font f=new Font("TH Sarabun New", Font.PLAIN, 20);

    public DeleteBook()
    {
        setDisplay();

        btDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                checkID(tfBookCode.getText());
                tfBookCode.setText("");
            }
        });
    }
    //update table once delete book
    public void checkID(String id)
    {
        boolean found = false;
        for(int i=0; i<BookStore.books.size(); i++)
        {
            if(tbBooks.getValueAt(i, 1).equals(id))
            {
                BookStore.checkedDelete(i);
                BookStore.books.remove(i);
                FinalBookTable finalBookTable = new FinalBookTable();
                tbBooks.setModel(finalBookTable);//สร้าง object ตารางใหม่เพื่อ update ข้อมูลที่ถูกลบ
                tbBooks.setLocale(new Locale("th", "TH"));
                tbBooks.setFont(f);
                tbBooks.setRowHeight(40);
                setLayoutTable();
                DeleteSuccess success = new DeleteSuccess();
                found = true;
                break;
            }
        }
        if(!found)
        {
            DeleteFailed failed = new DeleteFailed();
        }
    }
    private void setLayoutTable()
    {
        TableColumnModel columnModel = tbBooks.getColumnModel();
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
        setContentPane(deletePage);
        setVisible(true);
        setSize(1920,1040);
        tbBooks.setModel(finalBookTable);
        setLayoutTable();
        tbBooks.setLocale(new Locale("th", "TH"));
        tbBooks.setFont(f);
        tbBooks.setRowHeight(40);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
}

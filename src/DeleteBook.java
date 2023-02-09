import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteBook extends JFrame{
    private JTextField tfBookCode;
    private JPanel deletePage;
    private JButton btDelete;
    private JTable tbBooks;

    public DeleteBook()
    {
        FinalBookTable finalBookTable = new FinalBookTable();
        setContentPane(deletePage);
        setVisible(true);
        pack();
        tbBooks.setModel(finalBookTable);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
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
                tbBooks.setModel(finalBookTable); //สร้าง object ตารางใหม่เพื่อ update ข้อมูลที่ถูกลบ
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
}

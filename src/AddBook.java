import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

public class AddBook extends JFrame {
    private JTextField tfBookCode;
    private JTextField tfBookName;
    private JTextField tfBookPrice;
    private JTextArea taBookDetails;
    private JPanel addBookPage;
    private JButton btAdd;
    private JTable tbBooks;
    private JSpinner snTotal;
    private boolean isbnExists = false;
    Font f=new Font("TH Sarabun New", Font.PLAIN, 20);


    public AddBook()
    {
        setDisplay();

        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                addBookOnList();
            }
        });
    }
    private void addBookOnList()
    {
        for (int i = 0; i < BookStore.books.size(); i++) {
            if (BookStore.books.get(i).getIsbn().equals(tfBookCode.getText())) {
                BookStore.books.get(i).setBookTotal(BookStore.books.get(i).getBookTotal() + (Integer)snTotal.getValue()); //update total on arraylist
                FinalBookTable finalBookTable = new FinalBookTable();
                tbBooks.setModel(finalBookTable);
                setLayoutTable();
                tbBooks.setLocale(new Locale("th", "TH"));
                tbBooks.setFont(f);
                isbnExists = true;
                BookStore.checkCode(i);
                break;
            }
            isbnExists = false;
        }
        if (!isbnExists) {
            Book book = new Book(); //สร้าง object book ขึ้นมา
            book.setIsbn(tfBookCode.getText());
            book.setBookName(tfBookName.getText());
            book.setBookDetails(taBookDetails.getText());
            book.setBookPrice(Double.parseDouble(tfBookPrice.getText()));
            book.setBookTotal((Integer)snTotal.getValue());
            BookStore.books.add(book); //add the book object to the array
            BookStore.checkAddBook(BookStore.books.size()-1);
            FinalBookTable finalBookTable = new FinalBookTable();
            tbBooks.setModel(finalBookTable);
            setLayoutTable();
            tbBooks.setLocale(new Locale("th", "TH"));
            tbBooks.setFont(f);
    }

        tfBookCode.setText("");
        tfBookName.setText("");
        tfBookPrice.setText("");
        taBookDetails.setText("");
        snTotal.setValue(1);
        PopUpSuccess success = new PopUpSuccess();
    }
    private void setLayoutTable()
    {
        tbBooks.setRowHeight(40);
        TableColumnModel columnModel = tbBooks.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(70);
        columnModel.getColumn(2).setPreferredWidth(250);
        columnModel.getColumn(3).setPreferredWidth(2000);
        columnModel.getColumn(4).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(50);
    }

    private void setThaiLanguage()
    {
        tfBookName.setFont(f);
        taBookDetails.setFont(f);
        tbBooks.setLocale(new Locale("th", "TH"));
        tbBooks.setFont(f);
    }

    private void setDisplay()
    {
        setContentPane(addBookPage);
        setVisible(true);
        setSize(1920,1040);
        setThaiLanguage();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        taBookDetails.setLineWrap(true);
        taBookDetails.setWrapStyleWord(true);
        FinalBookTable finalBookTable = new FinalBookTable();
        tbBooks.setModel(finalBookTable);
        setLayoutTable();
        snTotal.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1));
    }
}

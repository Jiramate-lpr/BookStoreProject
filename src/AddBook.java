import javax.swing.*;
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
        tfBookName.setFont(f);
        taBookDetails.setFont(f);
        taBookDetails.setLineWrap(true);
        taBookDetails.setWrapStyleWord(true);
        tbBooks.setLocale(new Locale("th", "TH"));
        tbBooks.setFont(f);

        FinalBookTable finalBookTable = new FinalBookTable();
        tbBooks.setRowHeight(40);
        setContentPane(addBookPage);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        tbBooks.setModel(finalBookTable);
        snTotal.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1));

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
}

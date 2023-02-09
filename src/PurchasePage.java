import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PurchasePage extends JFrame {
    private JTextField tfBookCode;
    private JSpinner snAmount;
    private JButton btPurchase;
    private JPanel purchasePage;
    private JTable tbStock;
    private JButton btHistory;


    public PurchasePage() {
        FinalBookTable finalBookTable = new FinalBookTable();
        setContentPane(purchasePage);
        setVisible(true);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        tbStock.setModel(finalBookTable);
        snAmount.setModel(new javax.swing.SpinnerNumberModel(1, 1, 999, 1));
        btPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkID(tfBookCode.getText(), (int) snAmount.getValue());
            }
        });
        btHistory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PurchaseHistory history = new PurchaseHistory();
            }
        });
    }

    private void checkID(String bookID, int amount) {
        boolean found = false;

        for (int i = 0; i < BookStore.books.size(); i++) //กำหนด scope ในการตรวจสอบรหัสหนังสือในคลัง
        {
            if (tbStock.getValueAt(i, 1).equals(bookID)) {
                found = true; //แบ่งเป็นกรณีที่เลขตรงกัน กับ ไม่ตรงกัน ก่อน
                if (Integer.valueOf(String.valueOf(tbStock.getValueAt(i, 5))) == amount) //กรณีซื้อหมดทุกจำนวณ
                {
                    addOrderedBookToHistory(i, amount);
                    BookStore.sold(i, amount);
                    BookStore.books.remove(i);
                    FinalBookTable finalBookTable = new FinalBookTable();
                    tbStock.setModel(finalBookTable);
                    PurchaseSuccess success = new PurchaseSuccess();
                    System.out.println("Success");
                    break;
                }
                else if (Integer.valueOf(String.valueOf(tbStock.getValueAt(i, 5))) > amount) //กรณีซื้อน้อยกว่าจำนวนที่มีอยู่
                {
                    addOrderedBookToHistory(i, amount);
                    BookStore.books.get(i).setBookTotal(BookStore.books.get(i).getBookTotal() - amount);
                    FinalBookTable finalBookTable = new FinalBookTable();
                    tbStock.setModel(finalBookTable);
                    PurchaseSuccess success = new PurchaseSuccess();
                    BookStore.sold(i, amount);
                    System.out.println("Success");
                    break;
                }
                else if (Integer.valueOf(String.valueOf(tbStock.getValueAt(i, 5))) < amount) //กรณีจำนวนสินค้าไม่เพียงพอ
                {
                    OverVolume overVolume = new OverVolume();
                    System.out.println("Over Volume");
                    break;
                }
            }
        }
        if (!found) //กรณีกรอกรหัสสินค้าผิด
        {
            PurchaseFailed failed = new PurchaseFailed();
            System.out.println("Cannot found ID");
        }
        tfBookCode.setText("");
        snAmount.setValue(1);
    }
    private void addOrderedBookToHistory(int i, int amount)
    {
        Book orderedBook = new Book(); //ไว้สำหรับ add เข้าไปใน arraylist ใหม่
        orderedBook.setIsbn(String.valueOf(BookStore.books.get(i).getIsbn()));
        orderedBook.setBookName(String.valueOf(BookStore.books.get(i).getBookName()));
        orderedBook.setBookDetails(String.valueOf(BookStore.books.get(i).getBookDetails()));
        orderedBook.setBookPrice(Double.parseDouble(String.valueOf(BookStore.books.get(i).getBookPrice())));
        orderedBook.setBookTotal(amount);
        BookStore.purchaseOrder.add(orderedBook); //added new array
        BookStore.checkOrder(BookStore.purchaseOrder.size()-1);
    }
}

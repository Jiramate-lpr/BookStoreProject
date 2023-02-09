import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoginPage first = new LoginPage();
        BookStore.books = new ArrayList<Book>(); //สร้าง container
        BookStore.purchaseOrder = new ArrayList<Book>();
    }
}
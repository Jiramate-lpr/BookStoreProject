import java.util.ArrayList;

public class BookStore {
    public static ArrayList<Book> books; //สร้างตัวแปรที่จะเก็บข้อมูล Book ที่เราจะ Add ในระบบ โดยเรียกใช้งานผ่าน Class นี้ ซึ่งการเรียกใช้ไม่ต้องผ่าน object >> Static
    public static ArrayList<Book> purchaseOrder;

    public static void checkAddBook(int index) //ตัว check ว่าหนังสือถูก add ไปจริงมั้ย
    {
        System.out.println("Book Details : ");
        System.out.println("ISBN : "+books.get(index).getIsbn());
        System.out.println("Name :"+books.get(index).getBookName());
        System.out.println("Details :"+books.get(index).getBookDetails());
        System.out.println("Price :"+books.get(index).getBookPrice());
    }
    public static void checkedDelete(int index) //ตัว check ว่าหนังสือถูก add ไปจริงมั้ย
    {
        System.out.println("Book Deleted Details : ");
        System.out.println("ISBN : "+books.get(index).getIsbn());
        System.out.println("Name : "+books.get(index).getBookName());
    }
    public static void sold(int index, int amount) //ตัว check ว่าหนังสือถูก add ไปจริงมั้ย
    {
        System.out.println("Book sold Details : ");
        System.out.println("ISBN : "+books.get(index).getIsbn());
        System.out.println("Name : "+books.get(index).getBookName());
        System.out.println("Amount : "+books.get(index).getBookTotal());
    }
    public static void checkCode(int index) //check added book code
    {
        System.out.println("Total of isbn "+books.get(index).getIsbn()+ " is : "+books.get(index).getBookTotal());
    }

    public static void checkOrder(int index) //check ordered book code
    {
        System.out.println("Total of "+purchaseOrder.get(index).getIsbn()+ " is : "+purchaseOrder.get(index).getBookTotal());
    }

    public static void checkPurchaseBook(int index) //ตัว check ว่าหนังสือถูก add ไปจริงมั้ย
    {
        System.out.println("Book sold Details : ");
        System.out.println("ISBN : "+purchaseOrder.get(index).getIsbn());
        System.out.println("Name : "+purchaseOrder.get(index).getBookName());
        System.out.println("Details : "+purchaseOrder.get(index).getBookDetails());
        System.out.println("Price : "+purchaseOrder.get(index).getBookPrice());
        System.out.println("Amount : "+purchaseOrder.get(index).getBookTotal());
    }
}

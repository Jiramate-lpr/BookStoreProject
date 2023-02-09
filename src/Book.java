public class Book {
    private String isbn = "";
    private String bookName = "";
    private String bookDetails = "";
    private double bookPrice = 0;
    private int bookTotal = 1;

    public String getIsbn()
    {
        return isbn;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(String bookDetails) {
        this.bookDetails = bookDetails;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookTotal()
    {
        return bookTotal;
    }
    public void setBookTotal(int bookTotal)
    {
        this.bookTotal = bookTotal;
    }
}

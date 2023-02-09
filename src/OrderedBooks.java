import javax.swing.table.AbstractTableModel;

public class OrderedBooks extends AbstractTableModel {
    private final String[] COLUMN = {"No", "ISBN", "Name", "Description", "Price", "Total"};
    @Override
    public int getRowCount() {
        return BookStore.purchaseOrder.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                BookStore.purchaseOrder.get(rowIndex).getIsbn();
            case 2:
                BookStore.purchaseOrder.get(rowIndex).getBookName();
            case 3:
                BookStore.purchaseOrder.get(rowIndex).getBookDetails();
            case 4:
                BookStore.purchaseOrder.get(rowIndex).getBookPrice();
            case 5:
                BookStore.purchaseOrder.get(rowIndex).getBookTotal();
            default:
                return null;
        }
    }
    public String getColumnName(int columnIndex)
    {
        return COLUMN[columnIndex];
    }
}

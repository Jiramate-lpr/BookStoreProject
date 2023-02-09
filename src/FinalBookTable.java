import javax.swing.table.AbstractTableModel;

public class FinalBookTable extends AbstractTableModel{
        private final String[] COLUMN = {"No", "ISBN", "Name", "Description", "Price", "Total"};

        @Override
        public int getRowCount() {
            return BookStore.books.size();
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
                    return BookStore.books.get(rowIndex).getIsbn();
                case 2:
                    return BookStore.books.get(rowIndex).getBookName();
                case 3:
                    return BookStore.books.get(rowIndex).getBookDetails();
                case 4:
                    return BookStore.books.get(rowIndex).getBookPrice();
                case 5:
                    return BookStore.books.get(rowIndex).getBookTotal();
                default:
                    return null;
            }
        }
        public String getColumnName(int columnIndex)
        {
            return COLUMN[columnIndex];
        }
}

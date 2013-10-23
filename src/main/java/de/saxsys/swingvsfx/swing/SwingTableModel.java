package de.saxsys.swingvsfx.swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import de.saxsys.swingvsfx.model.TableRowData;

public class SwingTableModel extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = -9173521374653096757L;
    
    private List<TableRowData> tableData;

    public SwingTableModel(List<TableRowData> tableData) {
        this.tableData = tableData;
    }

    public int getRowCount() {
        return this.tableData.size();
    }

    public int getColumnCount() {
        return 10;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.tableData.get(rowIndex).getFirstProp();
            case 1:
                return this.tableData.get(rowIndex).getSecondProp();
            case 2:
                return this.tableData.get(rowIndex).getThirdProp();
            case 3:
                return this.tableData.get(rowIndex).getFourthProp();
            case 4:
                return this.tableData.get(rowIndex).getFifthProp();
            case 5:
                return this.tableData.get(rowIndex).getSixthProp();
            case 6:
                return this.tableData.get(rowIndex).getSeventhProp();
            case 7:
                return this.tableData.get(rowIndex).getEighthProp();
            case 8:
                return this.tableData.get(rowIndex).getNinethProp();
            case 9:
                return this.tableData.get(rowIndex).getTenthProp();
            default:
                return -1;
        }
    }

}

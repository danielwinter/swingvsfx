package de.saxsys.swingvsfx.swing;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SwingTableCellRenderer extends JLabel implements TableCellRenderer {

    /**
     * 
     */
    private static final long serialVersionUID = 4966696875559148876L;

    public SwingTableCellRenderer() {
        this.setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {        
        this.setText(String.valueOf(value));
        int cellValue = (Integer) table.getValueAt(row, column);       
        if(cellValue < 300) {
            this.setBackground(Color.RED);
        }
        if(cellValue >= 300 && cellValue <= 600) {
            this.setBackground(Color.YELLOW);
        }
        if(cellValue > 600) {
            this.setBackground(Color.GREEN);
        }
        return this;
    }
}
package de.saxsys.swingvsfx.swing;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sun.prism.paint.Color;

import de.saxsys.swingvsfx.model.TableRowData;
import de.saxsys.swingvsfx.performance.IPerformanceComponent;

public class SwingTable extends JPanel implements IPerformanceComponent {

    /**
     * 
     */
    private static final long serialVersionUID = 4981455674236134326L;
    
    private List<TableRowData> tableData;
    
    public SwingTable(List<TableRowData> tableData) {
        this.tableData = tableData;
    }

    public void initPerformancPanel() {
        this.setLayout(new BorderLayout());

        SwingTableModel tableModel = new SwingTableModel(tableData);       
        JTable licenseTable = new JTable(tableModel);
        licenseTable.setDefaultRenderer(Object.class, new SwingTableCellRenderer());
        JScrollPane tablePane = new JScrollPane(licenseTable);

        this.add(tablePane, BorderLayout.CENTER);        
    }

    public Object getComponent() {
        return this;
    }

    public void updatePerformancePanel() {
        // TODO Auto-generated method stub
        
    }
}

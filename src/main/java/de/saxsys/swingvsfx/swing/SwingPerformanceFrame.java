package de.saxsys.swingvsfx.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import de.saxsys.swingvsfx.model.TableRowData;
import de.saxsys.swingvsfx.performance.IPerformanceContainer;
import de.saxsys.swingvsfx.performance.PerformanceResult;
import de.saxsys.swingvsfx.performance.PerformanceTester;
import de.saxsys.swingvsfx.random.RandomGenerator;

public class SwingPerformanceFrame extends JFrame implements IPerformanceContainer{

    /**
     * 
     */
    private static final long serialVersionUID = -1848087783842760836L;
    
    
    private JTabbedPane tabbedPane;
    
    private JButton testTableButton;
    private JTextField rowsAmountField;
    
    private JTextArea loggerArea;
    
    public SwingPerformanceFrame() {
        super("Swing-Performance");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.initGui();        
    }
    
    private void initGui() {
        this.setLayout(new BorderLayout());
        
        this.tabbedPane = new JTabbedPane();
        JPanel buttonPanel = this.getButtonPanel();
        JPanel loggerPanel = this.getLoggerPanel();
        
        this.add(buttonPanel, BorderLayout.WEST);
        this.add(this.tabbedPane, BorderLayout.CENTER);
        this.add(loggerPanel, BorderLayout.SOUTH);        
    }
    
    private JPanel getLoggerPanel() {
        JPanel loggerPanel = new JPanel();
        loggerPanel.setLayout(new BorderLayout());
        
        this.loggerArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(this.loggerArea);
        
        loggerPanel.add(scrollPane, BorderLayout.CENTER);
        loggerPanel.setPreferredSize(new Dimension(1024, 200));
        return loggerPanel;
    }
    
    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();        
        
        JLabel rowLabel = new JLabel("Rows:");
        this.rowsAmountField = new JTextField("1000000");
        
        this.testTableButton = new JButton("Test JTable");
        this.testTableButton.addActionListener(new TableListener());
        
        gc.insets = new Insets(5, 5, 5, 5);
        
        this.setGridConstraints(buttonPanel, rowLabel, gc, 0, 0, GridBagConstraints.HORIZONTAL, 
                GridBagConstraints.NORTHWEST, 1, 0, 1);
        this.setGridConstraints(buttonPanel, this.rowsAmountField, gc, 1, 0, GridBagConstraints.HORIZONTAL, 
                GridBagConstraints.NORTHWEST, 1, 0, 1);
        this.setGridConstraints(buttonPanel, testTableButton, gc, 0, 1, GridBagConstraints.HORIZONTAL, 
                GridBagConstraints.NORTHWEST, 1, 1, 2);
        return buttonPanel;
    }
    
    public void setGridConstraints(JPanel panel, JComponent component, GridBagConstraints gc,
            int gridx, int gridy, int fill, int anchor, int weightx, int weighty, int gridwidth) {
        gc.gridx = gridx;
        gc.gridy = gridy;
        gc.fill = fill;
        gc.anchor = anchor;
        gc.weightx = weightx;
        gc.weighty = weighty;
        gc.gridwidth = gridwidth;
        
        panel.add(component, gc);
    }
    
    public void addPerformancePanel(final Object performancePanel) {
        SwingUtilities.invokeLater(new Runnable() {            
            public void run() {
                JComponent panel = (JComponent) performancePanel;        
                SwingPerformanceFrame.this.tabbedPane.add("Performance-Test", panel);
            }
        });   
    }
    
    public void printPerformanceResult(final PerformanceResult result) {
        SwingUtilities.invokeLater(new Runnable() {            
            public void run() {
                SwingPerformanceFrame.this.loggerArea.append("Performance: " +result.getPerformanceInSeconds() +" Seconds." +
                        "(" +result.getStartTimeinNano() +", " +result.getEndTimeInNano() +")\n");                               
            }
        });        
    }
    
    private class TableListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Thread(new Runnable() {                
                public void run() {
                    List<TableRowData> tableData = RandomGenerator.createTableRowData(Integer.parseInt(rowsAmountField.getText().trim()));
                    PerformanceTester tester = new PerformanceTester();
                    PerformanceResult result = tester.testPerformanceAtInit(new SwingTable(tableData), SwingPerformanceFrame.this);
                    SwingPerformanceFrame.this.printPerformanceResult(result);                    
                }
            }).start();            
        }        
    }
        
    public static void main(String[] args) {
        SwingPerformanceFrame spf = new SwingPerformanceFrame();
        spf.setVisible(true);
    }

    public Object getPaneToAdd() {
        return this.tabbedPane;
    }

}

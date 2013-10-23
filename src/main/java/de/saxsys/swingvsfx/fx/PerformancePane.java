package de.saxsys.swingvsfx.fx;

import java.util.List;

import de.saxsys.swingvsfx.model.TableRowData;
import de.saxsys.swingvsfx.performance.IPerformanceContainer;
import de.saxsys.swingvsfx.performance.PerformanceResult;
import de.saxsys.swingvsfx.performance.PerformanceTester;
import de.saxsys.swingvsfx.random.RandomGenerator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PerformancePane extends BorderPane implements IPerformanceContainer {

    private TabPane tabPane;

    private TextField rowField;
    private Button tableButton;
        
    private TextArea loggerArea;
    
    public PerformancePane() {
        this.initGui();
    }
    
    private void initGui() {        
        this.tabPane = new TabPane();
        VBox buttonBox = this.getButtonBox();
        Pane loggerPane = this.getLoggerPane();
        
        this.setLeft(buttonBox);
        this.setCenter(this.tabPane);
        this.setBottom(loggerPane);
    }

    private VBox getButtonBox() {
        VBox buttonBox = new VBox();
        
        this.rowField = new TextField("1000000");
        Label rowLabel = new Label("Rows");
        HBox rowBox = new HBox();
        rowBox.getChildren().addAll(rowLabel, this.rowField);
        rowBox.setSpacing(3);        
        
        this.tableButton = new Button("Test Table");
        
        this.tableButton.setOnAction(new TableEventHandler());
        this.tableButton.setMaxWidth(Double.MAX_VALUE);
        
        buttonBox.getChildren().addAll(rowBox, this.tableButton);        
        VBox.setMargin(rowBox, new Insets(3));
        VBox.setMargin(this.tableButton, new Insets(3));
        
        return buttonBox;
    }
    
    private StackPane getLoggerPane() {
        StackPane loggerPane = new StackPane();
        
        this.loggerArea = new TextArea();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(this.loggerArea);
        
        loggerPane.getChildren().add(this.loggerArea);
        return loggerPane;
    }
    
    public void addPerformancePanel(final Object performancePanel) {
        Platform.runLater(new Runnable() {            
            public void run() {
                Pane pane = (Pane) performancePanel;
                
                Tab tab = new Tab("Performance");
                tab.setContent(pane);
                tabPane.getTabs().add(tab);                
            }
        });       
    }
    
    public void printPerformanceResult(final PerformanceResult result) {
        Platform.runLater(new Runnable() {            
            public void run() {
                PerformancePane.this.loggerArea.appendText("Performance: " +result.getPerformanceInSeconds() +" Seconds." +
                		"(" +result.getStartTimeinNano() +", " +result.getEndTimeInNano() +")\n");                
            }
        });        
    }
    
    private class TableEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            new Thread(new Runnable() {                
                public void run() {
                    List<TableRowData> tableData = RandomGenerator.createTableRowData(Integer.parseInt(PerformancePane.this.rowField.getText().trim()));
                    PerformanceTester tester = new PerformanceTester();
                    PerformanceResult result = tester.testPerformanceAtInit(new FXTable(tableData), PerformancePane.this);
                    PerformancePane.this.printPerformanceResult(result);                    
                }
            }).start(); 
        }        
    }

    public Object getPaneToAdd() {
        return this.tabPane;
    }
}

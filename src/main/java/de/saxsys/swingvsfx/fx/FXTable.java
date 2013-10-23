package de.saxsys.swingvsfx.fx;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import de.saxsys.swingvsfx.model.TableRowData;
import de.saxsys.swingvsfx.performance.IPerformanceComponent;


public class FXTable extends StackPane implements IPerformanceComponent {

    private List<TableRowData> tableData;
    
    public FXTable(List<TableRowData> tableData) {
        this.tableData = tableData;
    }    

    public void initPerformancPanel() {
        TableView<TableRowData> tView = new TableView<TableRowData>();
        
        TableColumn<TableRowData, Integer> firstColumn = new TableColumn<TableRowData, Integer>("A");
        firstColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "firstProp"));
        firstColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> secondColumn = new TableColumn<TableRowData, Integer>("B");
        secondColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "secondProp"));
        secondColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> thirdColumn = new TableColumn<TableRowData, Integer>("C");
        thirdColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "thirdProp"));
        thirdColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> fourthColumn = new TableColumn<TableRowData, Integer>("D");
        fourthColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "fourthProp"));
        fourthColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> fifthColumn = new TableColumn<TableRowData, Integer>("E");
        fifthColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "fifthProp"));
        fifthColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> sixthColumn = new TableColumn<TableRowData, Integer>("F");
        sixthColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "sixthProp"));
        sixthColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> seventhColumn = new TableColumn<TableRowData, Integer>("G");
        seventhColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "seventhProp"));
        seventhColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> eighthColumn = new TableColumn<TableRowData, Integer>("H");
        eighthColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "eighthProp"));
        eighthColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> ninethColumn = new TableColumn<TableRowData, Integer>("I");
        ninethColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "ninethProp"));
        ninethColumn.setCellFactory(new CellFactory());
        
        TableColumn<TableRowData, Integer> tenthColumn = new TableColumn<TableRowData, Integer>("J");
        tenthColumn.setCellValueFactory(new PropertyValueFactory<TableRowData, Integer>(
                "tenthProp"));
        tenthColumn.setCellFactory(new CellFactory());
        
        ObservableList<TableRowData> obsTableData = FXCollections.observableArrayList(tableData);
        tView.setItems(obsTableData);
        tView.getColumns().setAll(firstColumn, secondColumn, thirdColumn, fourthColumn, fifthColumn, 
                sixthColumn, seventhColumn, eighthColumn, ninethColumn, tenthColumn);
        tView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        this.getChildren().add(tView);
        
    }

    public Object getComponent() {
        return this;
    }

    public void updatePerformancePanel() {
        // TODO Auto-generated method stub
        
    }
    
    private class CellFactory implements Callback<TableColumn<TableRowData, Integer>, TableCell<TableRowData,Integer>> {
        public TableCell<TableRowData,Integer> call(TableColumn<TableRowData, Integer> param) {
            TableCell<TableRowData, Integer> cell = new TableCell<TableRowData, Integer>() {
                @Override
                public void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(String.valueOf(item));
                    if(item < 300) {
                        this.setTextFill(Color.RED);
                    }
                    if(item >= 300 && item <= 600) {
                        this.setTextFill(Color.YELLOW);
                    }
                    if(item > 600) {
                        this.setTextFill(Color.GREEN);
                    }
                }
            };
            return cell;
        }
        
    }
    
}

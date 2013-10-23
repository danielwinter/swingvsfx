package de.saxsys.swingvsfx.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import de.saxsys.swingvsfx.model.TableRowData;

public class RandomGenerator {

    public static List<TableRowData> createTableRowData(final int rows) {
        List<TableRowData> tableRows = new ArrayList<TableRowData>();
       
        for (int row = 0; row < rows; row++) {
            Random random = new Random();
            TableRowData rowData = new TableRowData(random.nextInt(1000), random.nextInt(1000), random.nextInt(1000), 
                    random.nextInt(1000), random.nextInt(1000), random.nextInt(1000), random.nextInt(1000), 
                    random.nextInt(1000), random.nextInt(1000), random.nextInt(1000));
            tableRows.add(rowData);            
        }

        return tableRows;
    }
}

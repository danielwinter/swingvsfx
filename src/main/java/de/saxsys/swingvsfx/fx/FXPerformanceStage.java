package de.saxsys.swingvsfx.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class FXPerformanceStage extends Application {

    public static void main(String[] args) {        
        FXPerformanceStage.launch(args);       
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX");      
        
        Scene scene = new Scene(new PerformancePane(), 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

}

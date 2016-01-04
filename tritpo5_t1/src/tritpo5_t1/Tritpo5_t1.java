/*

 */
package tritpo5_t1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author Acer-PC
 */
public class Tritpo5_t1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        TryToFindAllFiles();
        //System.out.println(listWithFileNames.size());
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static ArrayList<File> listWithFileNames = new ArrayList<>();

    public void TryToFindAllFiles() {
        new filefinder("F:\\").start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

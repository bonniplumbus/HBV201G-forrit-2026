/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 * Dæmi um Valmyndir og context valmyndir
 */
public class ValmyndirMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("/vidmot/Valmyndir.fxml");
        if (url == null ){
            throw new IllegalStateException ("Valmyndir.fxml fannst ekki í resources");
        }
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

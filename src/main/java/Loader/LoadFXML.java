package Loader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Denis on 28.11.2016.
 */
public class LoadFXML {

    private AnchorPane anchorPane;

    public LoadFXML(AnchorPane anchorPane){
        this.anchorPane = anchorPane;

    }

    public void loadFXML( String path){

        try {
            anchorPane = FXMLLoader.load(getClass().getResource(path));
            Scene scene = new Scene(anchorPane);

            //primaryStage.setScene(scene);

            //primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

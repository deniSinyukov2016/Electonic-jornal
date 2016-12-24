import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Denis on 24.10.2016.
 */
public class Main extends Application {

    private Stage primaryStage;
    private AnchorPane rootPane;



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Школьный журнал");
       // this.primaryStage.setOpacity(0.9f);

        initRoot();



    }

    private void initRoot() {

        try {
            rootPane = FXMLLoader.load(getClass().getResource("View/table_class.fxml"));
            Scene scene = new Scene(rootPane);

            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

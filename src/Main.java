import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @FXML
    private ImageView logoBannerView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent mainRoot = null;
        try {
            mainRoot = FXMLLoader.load(getClass().getResource("UiView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logoBannerView = new ImageView(new Image(getClass().getResourceAsStream("resources/Park_Plant_Banner.png")));
        primaryStage.setTitle("Park Plant");
        primaryStage.setScene(new Scene(mainRoot,800,600));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}

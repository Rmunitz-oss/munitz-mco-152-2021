package munitz.scrabble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScrabbleBoardApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/scrabble_board_application.fxml"));
        Scene scene = new Scene(root,400,300);
        stage.setTitle("Scrabble Board");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

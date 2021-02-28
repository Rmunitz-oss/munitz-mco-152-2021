package munitz.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RocketController {
    @FXML
    TextField velocityField;
    @FXML
    TextField angleField;
    @FXML
    TextField secondsField;
    @FXML
    Label locationLabel;
    @FXML
    RocketCanvas rocketCanvas;

    public void calculateRocket(ActionEvent actionEvent) {
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());
        Rocket rocket = new Rocket(velocity, angle);
        String rocketLocation = String.format("Rocket location: (%.2f, %.2f) ",
                rocket.getX(seconds),
                rocket.getY(seconds));
        locationLabel.setText(rocketLocation);
        rocketCanvas.draw(rocket);
    }
}

package munitz.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RocketController {
    @FXML
    TextField velocityField;
    @FXML
    TextField angleField;
    @FXML
    TextField secondsField;
    @FXML
    Text xCoordinateText;
    @FXML
    Text yCoordinateText;
    @FXML
    Text flightTimeText;
    @FXML
    RocketCanvas rocketCanvas;

    public void calculateRocket(ActionEvent actionEvent) {
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);
        xCoordinateText.setText(String.valueOf(rocket.getX(seconds)));
        yCoordinateText.setText(String.valueOf(rocket.getY(seconds)));
        flightTimeText.setText(String.valueOf(rocket.getFlightTime()));

        rocketCanvas.draw(rocket);
    }
}

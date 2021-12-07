package munitz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ScrabbleController {
    @FXML
    TextField wordToFindField;
    @FXML
    Text searchResultText;

    public void searchDictionary(ActionEvent actionEvent) throws IOException {
        String wordToFind = wordToFindField.getText().toUpperCase();
        Scrabble scrabble = new Scrabble();
        String searchResult = (scrabble.findWord(wordToFind)) ? "Found" : "Not found";
        searchResultText.setText(searchResult);
    }
}

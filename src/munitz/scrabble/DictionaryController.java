package munitz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DictionaryController {
    @FXML
    TextField filePathField;
    @FXML
    TextField wordToFindField;
    @FXML
    Text searchResultText;

    public void searchDictionary(ActionEvent actionEvent){
        String filepath = filePathField.getText();
        String wordToFind = wordToFindField.getText().toUpperCase();
        Dictionary dictionary = new Dictionary(filepath);
        String searchResult = (dictionary.findWord(wordToFind)) ? "Found" : "Not found";
        searchResultText.setText(searchResult);
    }
}

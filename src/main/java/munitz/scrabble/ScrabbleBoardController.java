package munitz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;

public class ScrabbleBoardController{
    @FXML
    List<Label> answerLabels;
    @FXML
    List<Button>letterButtons;
    @FXML
    Label pointsLabel;
    @FXML
    Label invalidWordLabel;
    @FXML
    Label gameOverLabel;

    private final LetterBag letterBag;
    private final Scrabble dictionary;
    private int points;

    // Dependency Injection
    public ScrabbleBoardController (Scrabble dictionary, LetterBag letterBag){
            this.dictionary = dictionary;
            this.letterBag = letterBag;
    }

    @FXML
    public void initialize(){
        points = 0;
        for (Button letterButton: letterButtons){
           letterButton.setText(letterBag.nextLetter());
        }
    }

    /**
     * remove selected tile from answer
     * @param event user clicks on answer letter tile
     */
    public void onAnswerClicked(javafx.scene.input.MouseEvent event){
        Label letter = (Label) event.getSource();
        String letterSelected = letter.getText(); // get letter user chose
        if (letterSelected != "") {              //ensure user chose a valid tile
            letter.setText("");                 //remove selected letter from tile
            for (Button letterButton : letterButtons){
                if (letterButton.getText() == ""){    //return selected letter to empty letter button
                    letterButton.setText(letterSelected);
                    break;
                }
            }
        }
    }

    /**
     * add selected tile to answer
     * @param event user clicks on letter button
     */
    public void onLetterButtonClicked(javafx.scene.input.MouseEvent event){
        Button letter = (Button) event.getSource();
        String letterSelected = letter.getText();   //get letter user chose
        if(letterSelected != ""){                   //ensure user chose valid tile
            for (Label answerLetter : answerLabels){
                if (answerLetter.getText() == ""){         //find next empty answer tile
                    answerLetter.setText(letterSelected);   //set answer tile
                    letter.setText("");                     //clear letter button
                    break;
                }
            }
        }
    }

    /**
     * clear answer tiles and return letters to letter buttons
     * @param actionEvent user clicks clear button
     */
    public void onClear(ActionEvent actionEvent) {
        for(Label answerLetter : answerLabels) {
            String selectedLetter = answerLetter.getText();
            for (Button letterButton : letterButtons){
                if (letterButton.getText().equals("")){
                    letterButton.setText(selectedLetter);
                    break;
                }
            }
            answerLetter.setText("");
        }
    }

    /**
     * validate user's word, calculate, replace empty letter tiles
     * @param actionEvent user clicks submit button
     */
    public void onSubmit(ActionEvent actionEvent) {
        StringBuilder word = new StringBuilder();
        for (Label answerLetter : answerLabels){   // get user's word
            if(answerLetter.getText()!=""){
                word.append(answerLetter.getText());
            }
        }
        if(dictionary.findWord(word.toString())) {  // validate word exists in dictionary
            calculatePoints(word.length());// calculate points
            invalidWordLabel.setText("");
        }
        else{
            invalidWordLabel.setText("Invalid word");
        }
        resetTiles();
    }

    /**
     * calculate points based on word length
     * @param wordLength int
     */
    public void calculatePoints(int wordLength) {
        switch (wordLength){
            case 2: points+=1;
                break;
            case 3: points+=3;
                break;
            case 4: points+=5;
                break;
            case 5: points+=7;
                break;
            case 6: points+=11;
                break;
            case 7: points+=13;
                break;
            default:points+=0;
                break;
        }
        pointsLabel.setText(String.valueOf(points));
    }

    /**
     * clear answer tiles and reset letter buttons
     * as long as letterBag is not empty
     */
    private void resetTiles (){
        for(Label answerLetter : answerLabels) {
            answerLetter.setText("");
        }
        for (Button letterButton: letterButtons){
            if(!letterBag.isEmpty()){
                letterButton.setText(letterBag.nextLetter());
            }
            else{
                gameOverLabel.setText("Game Over, no more letters.");
                break;
            }

        }
    }
}

package munitz.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleBoardController{
    @FXML
    List<Label> answerLabels;
    @FXML
    List<Button>letterButtons;
    @FXML
    Label pointsLabel;

    private LetterBag letterBag = new LetterBag();
    private Scrabble dictionary;
    private int points;

    public ScrabbleBoardController (){
        try{
            dictionary = new Scrabble();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    /**
     * initialize game
     */
    public void initialize(){
        points = 0;
        for (Button letterButton: letterButtons){
            letterButton.setText(letterBag.nextLetter());
        }
    }

    /**
     *
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
     *
     * @param event user clicks on letter button
     */
    public void onLetterButtonClicked(javafx.scene.input.MouseEvent event){
        Button letter = (Button) event.getSource();
        String letterSelected = letter.getText();   //get letter user chose
        if(letterSelected != ""){                   //ensure user chose valid tile
            for (Label answerLetter : answerLabels){
                if (answerLetter.getText() == " "){         //find next empty answer tile
                    answerLetter.setText(letterSelected);   //set answer tile
                    letter.setText("");                     //clear letter button
                    break;
                }
            }
        }
    }

    /**
     * clear answer tiles
     * @param actionEvent user clicks clear button
     */
    public void onClear(ActionEvent actionEvent) {
        for(Label answerLetter : answerLabels) {
            answerLetter.setText(" ");
        }
    }

    /**
     * validate user's word and calculate points
     * @param actionEvent user clicks submit button
     */
    public void onSubmit(ActionEvent actionEvent) {
        StringBuilder word = new StringBuilder();
        for (Label answerLetter : answerLabels){   // get user's word
            if(answerLetter.getText()!=" "){
                String letter = answerLetter.getText();
                word.append(letter);
            }
        }
        int wordLength = word.length();             // calculate word length
        if(dictionary.findWord(word.toString())){   // validate word exists in dictionary
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
        else{
            //TO DO: add label to tell user their word is invalid
        }
        onClear(actionEvent);       //clear board
        if(!letterBag.isEmpty()){   //reset letter buttons
            for (Button letterButton: letterButtons){
                letterButton.setText(letterBag.nextLetter());
            }
        }

    }
}

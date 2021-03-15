package munitz.scrabble;

import java.util.*;

/**
 * holds the distribution of letters in our game
 * source:  http://www.bananagrammer.com/2009/07/letter-distributions-in-bananagrams-and.html
 */
public class LetterBag {

    private Stack<String> letterStack;

    public LetterBag(){
        List<String> letterList = Arrays.asList("A", "A", "A", "A", "A", "A", "A", "A", "A",
                "B", "B",
                "C", "C",
                "D","D","D","D",
                "E","E","E","E","E","E","E","E","E","E","E","E",
                "F","F",
                "G","G","G",
                "H","H",
                "I","I","I","I","I","I","I","I","I",
                "J",
                "K",
                "L","L","L","L",
                "M","M",
                "N","N","N","N","N","N",
                "O","O","O","O","O","O","O","O",
                "P","P",
                "Q",
                "R","R","R","R","R","R",
                "S","S","S","S",
                "T","T","T","T","T","T",
                "U","U","U","U",
                "V","V",
                "W","W",
                "X",
                "Y","Y",
                "Z");
        Collections.shuffle(letterList);
        letterStack = new Stack<>();
        letterStack.addAll(letterList);

    }

    /**
     *
     * @return next random letter from letter bag
     */
    public String nextLetter(){
        return letterStack.pop();
    }

    /**
     *
     * @return true if letter bag is empty,
     * false if it contains any more letters
     */
    public boolean isEmpty(){
        return letterStack.isEmpty();
    }
}

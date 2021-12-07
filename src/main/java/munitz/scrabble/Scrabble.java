package munitz.scrabble;
import java.io.*;
import java.util.*;

public class Scrabble {
    private final Map<String,String> wordsToDefinition = new HashMap<>();

    public Scrabble() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        Scanner reader = new Scanner(in);
        while(reader.hasNext()){
            wordsToDefinition.put(reader.next(),reader.nextLine().trim());
        }

    }

    /**
     * searches dictionary for desired word
     * @param  wordToFind in dictionary
     * @return true if found, false if not
     */
    public boolean findWord (String wordToFind){
        return wordsToDefinition.containsKey(wordToFind.toUpperCase());
    }

    /**
     * returns dictionary definition of word provided
     * @param wordToDefine
     * @return String definition or empty string if word not found
     */
    public String getDefinition(String wordToDefine){
        String definition = wordsToDefinition.get(wordToDefine.toUpperCase());
        return definition == null ? "" : definition;
    }
}

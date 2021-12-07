package munitz.scrabble;
import java.io.*;
import java.util.*;

public class Scrabble {
    private final Map<String,String> wordsToDefinition = new HashMap<>();

    public Scrabble() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;

        while ((line = reader.readLine()) != null) {
            int index = line.indexOf(" ");
            String word = index == -1 ? line : line.substring(0, index);
            String definition = index > -1 ? line.substring(index + 1) : null;
            wordsToDefinition.put(word, definition);
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

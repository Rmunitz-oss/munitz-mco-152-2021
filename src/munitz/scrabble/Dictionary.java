package munitz.scrabble;
import java.io.*;
import java.util.*;

public class Dictionary {
    private ArrayList <String> dictionaryEntries = new ArrayList<>();

    /**
     * @param filePath of dictionary text file
     */
    public Dictionary(String filePath) {
        this.dictionaryEntries = buildDictionary(filePath);
    }

    /**
     * converts dictionary file to ArrayList of words
     * @param filePath of dictionary file
     * @return  list of dictionary entries
     */
    public ArrayList<String> buildDictionary(String filePath){
        try(Scanner scanner = new Scanner(new File(filePath))){
            while (scanner.hasNextLine()) {
                dictionaryEntries.add(scanner.next());
                scanner.nextLine();
            }
        }
        catch (FileNotFoundException error){
            System.out.println(error.getMessage());

        }
        return dictionaryEntries;
    }

    /**
     * searches dictionary for desired word
     * @param  wordToFind in dictionary
     * @return true if found, false if not
     */
    public boolean findWord (String wordToFind){
        for (String word : dictionaryEntries)
        {
            if (wordToFind.equals(word)){
                return true;
            }
        }
        return false;
    }
}

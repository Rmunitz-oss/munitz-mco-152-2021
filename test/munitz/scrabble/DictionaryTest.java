package munitz.scrabble;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;

public class DictionaryTest {
    @Test
    public void findWordTrue() throws FileNotFoundException {
        String filePath = "src/munitz/scrabble/dictionary.txt";
        Dictionary file = new Dictionary(filePath);
        boolean successfulSearch = file.findWord("Ash");
        Assert.assertTrue(successfulSearch);

    }
    @Test
    public void findWordFalse() throws FileNotFoundException{
        String filePath = "src/munitz/scrabble/dictionary.txt";
        Dictionary file = new Dictionary(filePath);
        boolean failedSearch = file.findWord("XYZ");
        Assert.assertFalse(failedSearch);
    }
}

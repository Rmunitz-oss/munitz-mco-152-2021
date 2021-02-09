package munitz.scrabble;
import org.junit.Assert;
import org.junit.Test;

public class DictionaryTest {
    @Test
    public void findWord() {
        String filePath = "C:/Users/roche/IdeaProjects/Word Search/src/dictionary.txt";
        Dictionary file = new Dictionary(filePath);
        boolean successfulSearch = file.findWord("ASH");
        Assert.assertTrue(successfulSearch);
        boolean failedSearch = file.findWord("XYZ");
        Assert.assertFalse(failedSearch);
    }
}

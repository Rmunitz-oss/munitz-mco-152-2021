package munitz.scrabble;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;

public class ScrabbleDictionaryTest {
    @Test
    public void findValidWord() throws FileNotFoundException {
        Scrabble scrabble = new Scrabble();
        assertTrue(scrabble.findWord("Ash"));
    }
    @Test
    public void findInvalidWord() throws FileNotFoundException{
        Scrabble scrabble = new Scrabble();
        assertFalse(scrabble.findWord("XYZ"));
    }
    @Test
    public void getDefinitionValidWord () throws FileNotFoundException {
        Scrabble scrabble = new Scrabble();
        assertEquals("in the company of [prep]",scrabble.getDefinition("with"));
    }
    @Test
    public void getDefinitionInvalidWord () throws FileNotFoundException {
        Scrabble scrabble = new Scrabble();
        assertEquals("",scrabble.getDefinition("xyz"));
    }

}

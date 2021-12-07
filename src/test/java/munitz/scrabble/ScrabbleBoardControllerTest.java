package munitz.scrabble;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;
import static org.mockito.Mockito.*;

public class ScrabbleBoardControllerTest {
    @BeforeClass
    public static void beforeClass(){
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }
    @Test
    public void initialize(){
        //given
        LetterBag letterBag = mock(LetterBag.class);
        Scrabble dictionary = mock(Scrabble.class);
        ScrabbleBoardController controller = new ScrabbleBoardController(dictionary,letterBag);
        controller.letterButtons = Arrays.asList(
                mock(Button.class),
                mock(Button.class),
                mock(Button.class)
        );
        doReturn("A","B", "C").when(letterBag).nextLetter();

        //when
        controller.initialize();

        //then
        verify(controller.letterButtons.get(0)).setText("A");
        verify(controller.letterButtons.get(1)).setText("B");
        verify(controller.letterButtons.get(2)).setText("C");
        verify(letterBag,times(3)).nextLetter();
    }

    public void onClear_noAnswer(){
        //given
        LetterBag letterBag = mock(LetterBag.class);
        Scrabble dictionary = mock(Scrabble.class);
        ScrabbleBoardController controller = new ScrabbleBoardController(dictionary,letterBag);

        //when
        controller.onClear(mock(ActionEvent.class));

        //then
        for (Label answerLabel : controller.answerLabels){
            verify(answerLabel).getText();
        }




    }
}

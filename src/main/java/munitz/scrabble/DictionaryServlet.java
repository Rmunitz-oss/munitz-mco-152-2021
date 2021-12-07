package munitz.scrabble;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DictionaryServlet extends HttpServlet {
    private final Scrabble dictionary;

    public DictionaryServlet() throws IOException {
        dictionary = new Scrabble();
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        PrintWriter out = response.getWriter();
        String wordToDefine = request.getParameter("wordToFind");
        String result;
        if (dictionary.findWord(wordToDefine)){
            result = dictionary.getDefinition(wordToDefine);
        }
        else{
            result = "That is not a valid word. ";
        }
        out.print(result);
    }



}

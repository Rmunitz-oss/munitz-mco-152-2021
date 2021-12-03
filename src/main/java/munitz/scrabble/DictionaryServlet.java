package munitz.scrabble;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DictionaryServlet {
    private final Scrabble dictionary;
    private final Gson gson;

    //remove json??
    public DictionaryServlet() throws IOException {
        dictionary = new Scrabble();
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

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
        String json = gson.toJson(result);
        out.print(result);
    }



}

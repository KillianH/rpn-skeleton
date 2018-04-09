package rpn.Parser;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void should_split_text_on_space(){
        Parser parser = new Parser();

        String str = "should split text on space";

        ArrayList<String> toCompare = new ArrayList<>();

        toCompare.add("should");
        toCompare.add("split");
        toCompare.add("text");
        toCompare.add("on");
        toCompare.add("space");

        assertEquals(toCompare, parser.parse(str));
    }

    @Test
    public void should_split_text_on_ampersand(){
        Parser parser = new Parser("&");

        String str = "should&split&text&on&space";

        ArrayList<String> toCompare = new ArrayList<>();

        toCompare.add("should");
        toCompare.add("split");
        toCompare.add("text");
        toCompare.add("on");
        toCompare.add("space");

        assertEquals(toCompare, parser.parse(str));
    }

    @Test
    public void should_not_split_text(){
        Parser parser = new Parser();

        String str = "should&split&text&on&space";

        ArrayList<String> toCompare = new ArrayList<>();

        toCompare.add("should&split&text&on&space");

        assertEquals(toCompare, parser.parse(str));
    }
}

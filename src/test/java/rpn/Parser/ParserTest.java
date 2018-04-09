package rpn.Parser;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void should_split_text_on_space(){
        Parser parser = new Parser();

        String str = "should split text on space";

        Stack<String> toCompare = new Stack<>();

        toCompare.push("should");
        toCompare.push("split");
        toCompare.push("text");
        toCompare.push("on");
        toCompare.push("space");

        assertEquals(toCompare, parser.parse(str));
    }

    @Test
    public void should_split_text_on_ampersand(){
        Parser parser = new Parser("&");

        String str = "should&split&text&on&space";

        Stack<String> toCompare = new Stack<>();

        toCompare.push("should");
        toCompare.push("split");
        toCompare.push("text");
        toCompare.push("on");
        toCompare.push("space");

        assertEquals(toCompare, parser.parse(str));
    }

    @Test
    public void should_not_split_text(){
        Parser parser = new Parser();

        String str = "should&split&text&on&space";

        Stack<String> toCompare = new Stack<>();

        toCompare.push("should&split&text&on&space");

        assertEquals(toCompare, parser.parse(str));
    }
}

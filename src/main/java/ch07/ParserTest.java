package ch07;

interface Parseable{
    public abstract void parse(String fileName);
}
class ParserManager {
    public static Parseable getParser(String type){
        if(type.equals("HTML")) return new HTMLParser();
        else return new XMLParser();

    }
}
class XMLParser implements Parseable{
    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - XML parsing success");
    }
}
class HTMLParser implements Parseable{
    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - HTML parsing success");
    }
}
public class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("HTML");
        parser.parse("document.html");
    }
}

//https://github.com/mlin1026/markdown-parse
import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
    assertEquals(2, 1 + 1);
    }
    
    @Test
    public void getLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("https://something.com", links.get(0));
        assertEquals("some-page.html", links.get(1));
    }

    @Test
        public void getLinks2() throws IOException {
            Path fileName = Path.of("breaking-test.md");
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals("www.gooog()le.com", links.get(0));
        }

        @Test
        public void getLinks3() throws IOException {
            Path fileName = Path.of("breaking-test_2.md");
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals("www.google.com\n[Lab Report 1](lab-report-1-week-2.html", links.get(0));
        }

        @Test
        public void getLinks4() throws IOException {
            Path fileName = Path.of("breaking-test_3.md");
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(0, links.size());
        }

        @Test
        public void getLinks5() throws IOException {
            Path fileName = Path.of("breaking-test_4.md");
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(0, links.size());
        }

        @Test
        public void testSnippet1() throws IOException {
            Path fileName = Path.of("snippet1.md");
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals("`google.com", links.get(0));
            assertEquals("google.com", links.get(1));
            assertEquals("ucsd.edu", links.get(2));
            assertEquals(3, links.size());
        }

        @Test
        public void testSnippet2() throws IOException {
            Path fileName = Path.of("snippet2.md");
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals("a.com", links.get(0));
            assertEquals("a.com(())", links.get(1));
            assertEquals("example.com", links.get(2));
             assertEquals(3, links.size());
        }

        @Test
        public void testSnippet3() throws IOException {
            Path fileName = Path.of("snippet3.md");
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(" https://ucsd-cse15l-w22.github.io/", links.get(0));
             assertEquals(1, links.size());
        }

}


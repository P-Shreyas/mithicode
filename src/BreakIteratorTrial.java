import java.text.BreakIterator;
public class BreakIteratorTrial {

    public static void main(String[] args) {
        String sent = "and other resources.\n" +
                "• TimeZone server for support of timezone information\n" +
                "• Dump/Restore command-line utilities for database backup, initialization, and\n" +
                "Mar 31, 2010\n" +
                "G";
        BreakIterator bi = BreakIterator.getWordInstance();
        bi.setText(sent);
        int index = 0;
        while (bi.next() != BreakIterator.DONE) {
            String sentence = sent.substring(index, bi.current());
            char c=sentence.charAt(0);
            if (c> 65 && c < 92)
            System.out.println("Sentence: " + sentence);
            index = bi.current();
        }



    }
}

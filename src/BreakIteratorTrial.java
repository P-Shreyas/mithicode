import java.text.BreakIterator;
public class BreakIteratorTrial {

    public static void main(String[] args) {
        String sent = "Chapter 1 Introducing Bedework 3.6\n" +
                "1.1\n" +
                "Bedework System Overview\n" +
                "Bedework is an open-source enterprise calendar system that supports public, personal, and\n" +
                "group calendaring. It is designed to conform to current calendaring standards with a goal of\n" +
                "attaining strong interoperability between other calendaring systems and clients. Bedework is\n" +
                "built with an emphasis on higher education, though it is used by many commercial\n" +
                "enterprises.\n" +
                "You may choose to deploy Bedework for public events calendaring, personal calendaring and\n" +
                "scheduling, or both. Bedework is suitable for embedding in other applications or in portals\n" +
                "and has been deployed across a wide range of environments.\n" +
                "Bedework System Architecture\n" +
                "Bedework 3.6 has a central server architecture and is modular and extensible. It consists of\n" +
                "the following components:\n" +
                "• Bedework core calendar engine\n" +
                "• Public events web client, called a “Calendar Suite”, for display of public events\n" +
                "•\n" +
                "•\n" +
                "•\n" +
                "•\n" +
                "•\n" +
                "Public events administration web client for entering public events, moderating\n" +
                "pending events from the submissions client, and configuring calendar suites\n";
        BreakIterator bi = BreakIterator.getWordInstance();
        bi.setText(sent);
        int index = 0;
        while (bi.next() != BreakIterator.DONE) {
            String sentence = sent.substring(index, bi.current());
            System.out.println("Sentence: " + sentence);
            index = bi.current();
        }
    }
}

import java.io.*;
import java.text.BreakIterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class App {

    static BufferedReader br;
    static Map<String,Existence> map;
    static BreakIterator bi=BreakIterator.getWordInstance();
    App(String path1,String path2, String path3,String outpath) {

        map=new HashMap<String, Existence>();

        try {
            String data=readStream(new FileInputStream(path1));
            this.doJob(data,1);

            data=readStream(new FileInputStream(path2));
            this.doJob(data,2);

            data=readStream(new FileInputStream(path3));
            this.doJob(data,3);

            this.printMap();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void printMap()
    {
        Map<String, Existence> treeMap = new TreeMap<String, Existence>(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        for (String str : treeMap.keySet()) {
            System.out.println(str);
        }
    }

    private void doJob(String data, int pageno) {
        bi.setText(data);
        int index = 0;
        while (bi.next() != BreakIterator.DONE) {
            String word = data.substring(index, bi.current());
            char c=word.charAt(0);
            if ((c> 64 && c < 90) || (c > 96 && c < 123))
            {
                this.addToMap(word,pageno);
            }
            index = bi.current();
        }
    }

    private void addToMap(String word, int pageno) {
        if(map.containsKey(word)) {
            switch (pageno) {
                case 1:
                    map.get(word).setP1();
                    break;

                case 2:
                    map.get(word).setP2();
                    break;

                case 3:
                    map.get(word).setP3();
                    break;

            }
        }
        else
        {
            Existence existence=new Existence();
            switch (pageno)
            {
                case 1:existence.setP1();break;

                case 2:existence.setP2();break;

                case 3:existence.setP3();break;
            }
            map.put(word,existence);
        }
    }



    public static String readStream(InputStream is) {
        StringBuilder sb = new StringBuilder(512);
        try {
            Reader r = new InputStreamReader(is, "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //Change you paths here
        String page1Path="D:\\mithicode\\To be given to candidate\\proj\\Page1.txt";
        String page2Path="D:\\mithicode\\To be given to candidate\\proj\\Page2.txt";
        String page3Path="D:\\mithicode\\To be given to candidate\\proj\\Page3.txt";
        String excludePath="D:\\mithicode\\To be given to candidate\\proj\\";
        String outputFilePath="D:\\mithicode\\To be given to candidate\\proj\\index.txt";
        new App(page1Path,page2Path,page3Path,outputFilePath);
    }
}

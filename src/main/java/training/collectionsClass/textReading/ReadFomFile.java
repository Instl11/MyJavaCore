package training.collectionsClass.textReading;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadFomFile {
    public static void main(String[] args) throws IOException {


        Set<String> uniqueWords = new HashSet<>();
        String filePath1 = "C:\\Users\\Instyle\\IdeaProjects\\OOP\\1.doc";
        String filePath2 = "C:\\Users\\Instyle\\IdeaProjects\\OOP\\1 BAK НП1...- A5.doc";
        String filePath3 = "C:\\Users\\Instyle\\IdeaProjects\\OOP\\Joyceulysses A4.doc";
        String filePath4 = "C:\\Users\\Instyle\\IdeaProjects\\OOP\\NF111 024-047 109-116. А5.doc";
        String filePath5 = "C:\\Users\\Instyle\\IdeaProjects\\OOP\\NF222 026-049...- А5.doc";
        String filePath6 = "C:\\Users\\Instyle\\IdeaProjects\\OOP\\Tolstoy_War_and_Peace.doc";

      //  uniqueWordsWithVarParam(uniqueWords, filePath2, filePath3, filePath4, filePath5, filePath6);
        countingUniqueWords(uniqueWords, filePath1);

        System.out.println(uniqueWords);
        System.out.println(uniqueWords.size());

    }

    private static void countingUniqueWords(Set<String> uniqueWords, String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        HWPFDocument doc = new HWPFDocument(fis);
        Range range = doc.getRange();

        for (int i = 0; i < range.numParagraphs(); i++){
            Paragraph par = range.getParagraph(i);
            String text = par.text().toLowerCase();
            String[] words = text.split("\\s+");

            for (int j = 0; j<words.length; j++){
                words[j] = words[j].replaceAll("\\W*(\\w+)\\W*", "$1");
                //words[j] = words[j].replaceAll("\\b(\\w+?)\\b", "$1");
                //words[j] = words[j].replaceAll("\\d+", "a");
            }

            List<String> list = new ArrayList<>(Arrays.asList(words));
            uniqueWords.addAll(list);
        }
    }
    private static void uniqueWordsWithVarParam(Set<String> uniqueWords, String ... filePath) throws IOException {
        for (String s : filePath){
            countingUniqueWords(uniqueWords, s);
        }
    }
}

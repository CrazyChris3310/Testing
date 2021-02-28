package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Defines methods for parsing from csv files.
 */
public class Parser {

    /**
     * Method returns array. Each elements is one line from file.
     * @param filePath file from where to parse.
     * @return array of lines from file.
     * @throws IOException if something went wrong.
     */
    public ArrayList<String> parseFromFile(File filePath) throws IOException {

        ArrayList<String> fileLines = new ArrayList<String>();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        int c;
        String text = "";
        do {
            c = isr.read();
            if ((char) c == '\n') {
                fileLines.add(text);
                text = "";
                continue;
            }
            text += (char) c;
        } while (c != -1);

        return fileLines;
    }

    /**
     * Divides fileLine on elements using comma as a delimiter.
     * @param fileLine {@code String} containing values separated by comma.
     * @return array of values from csv.
     */
    public ArrayList<String> getItems(String fileLine) {
        String[] splitedText = fileLine.split(",", 18);
        ArrayList<String> columnList = new ArrayList<String>();
        for (String s : splitedText) {
            //Если колонка начинается на кавычки или заканчиваеться на кавычки
            if (IsColumnPart(s)) {
                String lastText = columnList.get(columnList.size() - 1);
                columnList.set(columnList.size() - 1, lastText + "," + s);
            } else {
                columnList.add(s);
            }
        }

        return columnList;

    };

    /**
     * Checks if value is part of previous value.
     * @param text value to check.
     * @return true if text is part of previous value, false if not.
     */
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
}

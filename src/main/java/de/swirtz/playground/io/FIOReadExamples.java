package de.swirtz.playground.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by simonw on 13.04.17.
 */
public class FIOReadExamples {

    static final Path FILES_LOC = Paths.get("src/main/resources/");

    public static void main(String[] args) {
        try {
//            readWithFileReader();
            readWithBuffered();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readWithBuffered() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getFilePath("test.txt")))) {
            StringBuilder content = new StringBuilder("");
            String line;
            while (((line = bufferedReader.readLine()) != null)) {
                content.append(line).append("\n");
            }
            System.out.println("End of file reached. Result:\n\n" + content);
        }
    }

    private static void readWithFileReader() throws IOException {
        FileReader fReader = new FileReader(getFilePath("test.txt"));
        char[] fileContent = new char[1024];
        int totalChars = 0;
        int read;
        while ((read = fReader.read(fileContent)) != -1) {
            totalChars += read;
            System.out.println("Result of read: " + read);
        }
        System.out.println("totalRead: " + totalChars);
        fileContent = Arrays.copyOfRange(fileContent, 0, totalChars);
        System.out.println(fileContent);
    }

    static String getFilePath(String file) {
        return Paths.get(FILES_LOC.toString(), file).toString();
    }
}

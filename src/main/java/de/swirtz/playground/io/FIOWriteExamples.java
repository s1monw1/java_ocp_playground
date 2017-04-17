package de.swirtz.playground.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by simonw on 13.04.17.
 */
public class FIOWriteExamples extends FIOReadExamples {

    public static void main(String[] args) {
        try {
//            writeWithFileWriter();
//            writeWithBufferedFileWriter();
            writeWithBufferedFileWriterFromFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeWithEasyPrintWriter() throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new File(getFilePath("printWriterFile.out")))) {
            pw.println("I am printing to a file using PrintWriter");
            pw.printf("This is a formatted line with a simple string: %10s", "inserted string\n");
            pw.printf("This is a formatted line with numbers: %2$+10.2f ,%1$d", 28, 14.51634);
        }
    }


    private static void writeWithBufferedFileWriterFromFiles() throws IOException {
        try (BufferedWriter bufferedWriter =
                     Files.newBufferedWriter(Paths.get(getFilePath("test.txt")),
                             Charset.defaultCharset(),
                             StandardOpenOption.APPEND, StandardOpenOption.DSYNC)) {
            bufferedWriter.newLine();
            bufferedWriter.write("My new file content written with FileWriter");
            bufferedWriter.flush();
        }
    }

    private static void writeWithBufferedFileWriter() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getFilePath("newFile.bin")))) {
            if (!Files.exists(Paths.get(FILES_LOC.toString(), "newFile.bin"))) {
                throw new IllegalStateException("File was not created by FileWriter!");
            }
            bufferedWriter.write("My new file content written with FileWriter");
            bufferedWriter.flush();
        }
    }


    private static void writeWithFileWriter() throws IOException {
        try (FileWriter fWriter = new FileWriter(getFilePath("newFile.bin"))) {
            if (!Files.exists(Paths.get(FILES_LOC.toString(), "newFile.bin"))) {
                throw new IllegalStateException("File was not created by FileWriter!");
            }
            fWriter.write("My new file content written with FileWriter");
            fWriter.flush();
        }
    }
}

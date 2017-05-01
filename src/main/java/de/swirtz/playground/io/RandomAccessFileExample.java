package de.swirtz.playground.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by simonw on 24.04.17.
 */
public class RandomAccessFileExample {

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile("src/main/resources/test.txt", "rw")) {
            raf.seek(5);
            System.out.println(raf.readLine());
            raf.write(">randomaccess append<".getBytes());
        }

    }
}

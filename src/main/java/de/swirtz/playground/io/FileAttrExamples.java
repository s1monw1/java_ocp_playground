package de.swirtz.playground.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

/**
 * Created by simonw on 14.04.17.
 */
public class FileAttrExamples {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/test.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);

        System.out.println("Basic attributes");
        System.out.println("Creation time: "+basicFileAttributes.creationTime() + ", lastAccess: "+basicFileAttributes.lastAccessTime());
        System.out.println("POSIX attributes");
        System.out.println("Owner: "+posixFileAttributes.owner() + ", group: "+posixFileAttributes.group());

    }
}

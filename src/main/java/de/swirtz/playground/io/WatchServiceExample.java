package de.swirtz.playground.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Created by simonw on 24.04.17.
 */
public class WatchServiceExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("src/main/resources");
        final Path newFileForEvent = path.resolve("eventTrigger.bin");
        WatchService ws = path.getFileSystem().newWatchService();
        path.register(ws, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        startThreadToCreateFileInWatchedDir(newFileForEvent);
        out: while (true) {
            WatchKey key = ws.take();
            System.out.println("Got key: " + key);
            for (WatchEvent<?> e : key.pollEvents()) {
                System.out.println("Got Event: " + e.kind() + ", " + e.context());
                if(e.kind()==ENTRY_CREATE){
                    System.out.println("Delete "+newFileForEvent);
                    Files.deleteIfExists(newFileForEvent);
                }else{
                    break out;
                }
            }
            key.reset();
        }
    }

    private static void startThreadToCreateFileInWatchedDir(final Path newFileForEvent) {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(500);
                    Path created = Files.createFile(newFileForEvent);
                    System.out.println("Created: " + created);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

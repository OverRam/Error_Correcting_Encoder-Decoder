package correcter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class FileMenage {
    static byte[] readFileAsByteArr(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return "Value is null".getBytes();
    }

    static void writeToFile(byte[] arr, String fileName) {
        tryCreateFile(fileName);
        try (OutputStream printStream = new FileOutputStream(fileName)) {
            printStream.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void tryCreateFile(String patch) {
        File file = new File(patch);
        if (!file.exists()) {
            try {
                Files.createFile(Path.of(patch));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

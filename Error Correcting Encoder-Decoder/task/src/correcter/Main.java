package correcter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.print("Write a mode: ");
        String mode = new Scanner(System.in).nextLine();
        switch (mode) {
            case "send":
                send();
                break;
            case "encode":
                System.out.println("send.txt:");
                break;
            case "decode":
                System.out.println("received.txt:");
                break;
        }
    }


    private static void send() {
        try {
            byte[] encodedFileAsByteArr = Files.readAllBytes(Path.of("encoded.txt"));
            System.out.println("\nencoded.txt: ");
            printAsHex(encodedFileAsByteArr);
            printAsBinary(encodedFileAsByteArr);

            System.out.println("\nreceived.txt:");
            byte[] receivedFileAsByteArr = Files.readAllBytes(Path.of("received.txt"));
            printAsHex(receivedFileAsByteArr);
            printAsBinary(receivedFileAsByteArr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encode() {


    }

    private static void decode() {
        byte[] received = readFileAsByteArr("received.txt");
        byte[] decode = new byte[2];

        File decoded = tryCreateFile("decoded.txt");
        writeToFile(decode, "decoded.txt");

    }

    private static void printAsHex(byte[] arr) {
        System.out.print("hex view: ");
        for (byte e : arr) {
            System.out.print(Integer.toHexString(e) + " ");
        }
        System.out.println();
    }

    private static void printAsBinary(byte[] arr) {
        System.out.print("bin view: ");
        for (byte e : arr) {
            System.out.print(Integer.toBinaryString(e) + " ");
        }
        System.out.println();
    }

    static byte[] readFileAsByteArr(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void writeToFile(byte[] arr, String fileName) {
        try (OutputStream printStream = new FileOutputStream(fileName)) {
            printStream.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File tryCreateFile(String patch) {
        File file = new File(patch);
        if (!file.exists()) {
            try {
                Files.createFile(Path.of(patch));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

}
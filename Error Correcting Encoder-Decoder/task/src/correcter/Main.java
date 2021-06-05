package correcter;

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
                modeSend();
                break;
            case "encode":
                ModeEncode();
                break;
            case "decode":
                modeDecode();
                break;
        }
    }

    private static void modeSend() {
        byte[] encoded = FileMenage.readFileAsByteArr("encoded.txt");
        PrintAs.asHexAndBin(encoded, "encoded.txt");

        byte[] received = encodingError(encoded);
        PrintAs.asHexAndBin(received,"received");
        FileMenage.writeToFile(received, "received.txt");
    }

    private static byte[] encodingError(byte[] arr) {

        return arr;
    }

    private static void ModeEncode() {
        byte[] encoded = FileMenage.readFileAsByteArr("send.txt");

    }

    private static void modeDecode() {
        byte[] received = FileMenage.readFileAsByteArr("received.txt");
        byte[] decode = new byte[2];

        FileMenage.tryCreateFile("decoded.txt");
        FileMenage.writeToFile(decode, "decoded.txt");
    }

}
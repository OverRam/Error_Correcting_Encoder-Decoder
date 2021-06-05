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
                modeEncode();
                break;
            case "decode":
                modeDecode();
                break;
        }
    }

    private static void modeSend() {
        byte[] encoded = FileMenage.readFileAsByteArr("encoded.txt");
        PrintAs.asHexAndBin(encoded, "encoded.txt");

        byte[] received = simulateError(encoded);
        PrintAs.asHexAndBin(received, "received");
        FileMenage.writeToFile(received, "received.txt");
    }

    private static byte[] simulateError(byte[] arr) {

        return arr;
    }


    private static byte[] decoding(byte[] arr) {

        return arr;
    }

    private static void modeEncode() {
        byte[] send = FileMenage.readFileAsByteArr("send.txt");
        PrintAs.asHexAndBin(send, "send.txt");




    }

    private static void modeDecode() {
        byte[] encoded = FileMenage.readFileAsByteArr("encoded.txt");
        PrintAs.asHexAndBin(encoded, "encoded.txt");

        byte[] decode = new byte[2];

        FileMenage.tryCreateFile("decoded.txt");
        FileMenage.writeToFile(decode, "decoded.txt");
    }

}
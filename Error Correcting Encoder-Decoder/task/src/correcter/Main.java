package correcter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu("encode");
    }

    private static void menu(String mode) {
        System.out.print("Write a mode: ");
//        String mode = new Scanner(System.in).nextLine();
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
        System.out.println("byte " + send[0]);
        System.out.println("\nsend.txt:\ntext view: " + new String(send));
        PrintAs.asHexAndBin(send);
        String ex = expand(send);
        String parity = parity(ex);
        System.out.println("\nencoded.txt:\nexpand: " + ex + "\nparity: " + parity);
        byte[] part = strArrToByteArr(parity.split(" "));
        PrintAs.asHex(part);
    }

    private static String expand(byte[] arr) {
        String[] temp = new String[arr.length];
        StringBuilder exp = new StringBuilder();
        for (int i = 0, k = 0; i < arr.length; i++) {
            temp[i] = Integer.toBinaryString(arr[i]);
            //adding leading zeros if the string is less than 8 characters long
            if (8 - temp[i].length() == 1) {
                exp.append("0".repeat((8 - temp[i].length()) * 2));
                k += (8 - temp[i].length()) * 2;
                if (k % 6 == 0) {
                    exp.append(".. ");
                }
            }
            //doubling the value and putting periods at the end
            for (int j = 0; j < temp[i].length(); j++) {
                k += 2;
                exp.append(temp[i].charAt(j)).append(temp[i].charAt(j));
                if (k % 6 == 0) {
                    exp.append(".. ");
                }
            }
            //inserting missing dots
            if (i == arr.length - 1) {
                exp.append(".".repeat(Math.max(0, 8 - (k % 6))));
            }
        }
        return exp.toString();
    }

    private static String parity(String exp) {
        StringBuilder sb = new StringBuilder();
        String[] arrStr = exp.split(" ");
        int count;

        for (String s : arrStr) {
            count = 0;
            count += s.split("11").length;
            sb.append(s.replaceAll("\\.", count % 2 == 0 ? "1" : "0")).append(" ");
        }
        return sb.toString();
    }

    private static void modeDecode() {
        byte[] encoded = FileMenage.readFileAsByteArr("encoded.txt");
        PrintAs.asHexAndBin(encoded, "encoded.txt");

        byte[] decode = new byte[2];

        FileMenage.tryCreateFile("decoded.txt");
        FileMenage.writeToFile(decode, "decoded.txt");
    }

    private static byte[] strArrToByteArr(String[] intsArr) {
        byte[] arr = new byte[intsArr.length];
        int temp;
        int ind;
        for (int i = 0; i < intsArr.length; i++) {
            temp = 0;
            ind = 1;
            for (int j = intsArr[i].length() - 1; j >= 0; j--) {
                temp += Integer.parseInt(intsArr[i].charAt(j) + "") * ind;
                ind *= 2;
            }
            arr[i] = (byte) temp;
        }
        return arr;
    }
}
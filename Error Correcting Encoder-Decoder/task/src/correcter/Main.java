package correcter;

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
        System.out.println("\nsend.txt:\ntext view: " + new String(send));
        PrintAs.asHexAndBin(send);
        String ex = Expand.expandToDoubleBitsInByte(send);
        String parity = Parity.makeControlsBits(ex);
        System.out.println("\nencoded.txt:\nexpand: " + ex + "\nparity: " + parity);
        byte[] part = ConvertToArray.strArrToByteArr(parity.split(" "));
        PrintAs.asHex(part);
        FileMenage.writeToFile(part, "encoded.txt");
    }

    private static void modeDecode() {
        byte[] encoded = FileMenage.readFileAsByteArr("encoded.txt");
        PrintAs.asHexAndBin(encoded, "encoded.txt");

        byte[] decode = new byte[2];

        FileMenage.tryCreateFile("decoded.txt");
        FileMenage.writeToFile(decode, "decoded.txt");
    }

}
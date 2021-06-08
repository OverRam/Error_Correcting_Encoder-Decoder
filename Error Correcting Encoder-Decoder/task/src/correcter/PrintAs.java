package correcter;

public class PrintAs {
    static void asHexAndBin(byte[] arr, String fileName) {
        System.out.println("\n" + fileName + ": ");
        asHex(arr);
        asBinary(arr);
    }

    static void asHexAndBin(byte[] arr) {
        asHex(arr);
        asBinary(arr);
    }

    static void asHex(byte[] arr) {
        System.out.print("hex view: ");
        String s;
        for (byte e : arr) {
            s = Integer.toHexString(e).toUpperCase();
            s = s.length() < 2 ? s + s : s;
            System.out.print((s.length() > 3 ? s.subSequence(6, 8) : s) + " ");
        }
        System.out.println();
    }

    static void asBinary(byte[] arr) {
        System.out.print("bin view: ");
        for (byte e : arr) {
            System.out.print(Integer.toBinaryString(e) + " ");
        }
        System.out.println();
    }
}

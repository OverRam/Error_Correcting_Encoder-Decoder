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
        for (byte e : arr) {
            System.out.print(Integer.toHexString(e) + " ");
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

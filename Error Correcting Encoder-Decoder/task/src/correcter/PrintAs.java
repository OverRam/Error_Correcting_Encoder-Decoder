package correcter;

public class PrintAs {
    static void asHexAndBin(byte[] arr, String fileName) {
        if (arr != null) {
            System.out.println("\n" + fileName + ": ");
            asHex(arr);
            asBinary(arr);
        } else {
            System.out.println(fileName + " is null");
        }
    }

    private static void asHex(byte[] arr) {
        System.out.print("hex view: ");
        for (byte e : arr) {
            System.out.print(Integer.toHexString(e) + " ");
        }
        System.out.println();
    }

    private static void asBinary(byte[] arr) {
        System.out.print("bin view: ");
        for (byte e : arr) {
            System.out.print(Integer.toBinaryString(e) + " ");
        }
        System.out.println();
    }
}

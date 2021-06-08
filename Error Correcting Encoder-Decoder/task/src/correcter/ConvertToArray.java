package correcter;

public class ConvertToArray {
    static byte[] strBinCodeToByteArr(String[] intsArr) {
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

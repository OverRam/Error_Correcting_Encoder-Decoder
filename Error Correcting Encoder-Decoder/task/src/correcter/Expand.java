package correcter;

public class Expand {
    static String expandToDoubleBitsInByte(byte[] arr) {
        //expandToDoubleBitsInByte takes a byte array and duplicates the bits in the byte,
        // leaving the last 2 as ".." to be completed later as control bits.
        int len = arr.length;
        String[] temp = new String[len];
        StringBuilder exp = new StringBuilder();
        for (int i = 0, k = 0; i < len; i++) {
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
            if (i == len - 1) {
                exp.append(".".repeat(Math.max(0, 8 - (k % 6))));
            }
        }
        return exp.toString();
    }
}

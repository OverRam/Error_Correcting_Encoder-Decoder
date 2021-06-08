package correcter;

public class Parity {
    static String makeControlsBits(String exp) {
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
}

package app;

public final class Crypto {
    private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String caesarShift(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toUpperCase().toCharArray()) {
            int idx = ALPHA.indexOf(ch);
            if (idx >= 0) {
                int nidx = (idx + shift) % 26;
                sb.append(ALPHA.charAt(nidx));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

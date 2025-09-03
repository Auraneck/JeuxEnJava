package app;

import java.io.Console;

public final class Terminal {
    private Terminal(){}

    public static void clearScreen() {
        System.out.print("\u001B[2J\u001B[H");
        System.out.flush();
    }

    public static void printHeader(String title) {
        String border = "════════════════════════════════════════════════════════════════════";
        System.out.println(border);
        System.out.println(" " + title);
        System.out.println(border);
    }

    /** Read first non-empty char from a line (works cross-platform). */
    public static char readKey() throws java.io.IOException {
        int c = System.in.read();
        // consume rest of line if any
        while (System.in.available() > 0) {
            int cc = System.in.read();
            if (cc == '\n' || cc == '\r') break;
        }
        return (char)c;
    }
}

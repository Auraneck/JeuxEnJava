package app;

public final class Colors {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String[] RAINBOW = new String[]{
        "\u001B[31;5m", "\u001B[33;5m", "\u001B[32;5m",
        "\u001B[36;5m", "\u001B[34;5m", "\u001B[35;5m"
    };
    private Colors() {}
}

package elfa;

import java.util.UUID;

public class Utility {
    private static final String BLACK = "\u001B[30m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String PURPLE = "\u001B[35m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";
    private static final String WHITE = "\u001B[37m";
    private static final String YELLOW = "\u001B[33m";

    public static void printCmdLineColor(String color, String text) {
        String colorCode = getColorCode(color);
        System.out.println(colorCode + text + colorCode);
    }

    public static String getColorCode(String color) {
        return switch (color.toLowerCase()) {
            case "black" -> BLACK;
            case "blue" -> BLUE;
            case "cyan" -> CYAN;
            case "green" -> GREEN;
            case "purple" -> PURPLE;
            case "red" -> RED;
            case "yellow" -> YELLOW;
            case "white" -> WHITE;
            default -> RESET;
        };
    }

    public static String createUUID() {
        return UUID.randomUUID().toString();
    }
}

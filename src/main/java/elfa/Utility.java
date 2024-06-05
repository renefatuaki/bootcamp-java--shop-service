package elfa;

import java.util.UUID;

public class Utility {
    public static final String BLACK = "\u001B[30m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String WHITE = "\u001B[37m";
    public static final String YELLOW = "\u001B[33m";

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

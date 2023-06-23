import acm.graphics.GCanvas;
import acm.graphics.GLabel;

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;
public class HangmanCanvas extends GCanvas {
    /**
     * Resets the display so that only the hangman scaffold appears
     */
    public void resetHangman() {
        removeAll();

    }
    public void displayHangman(int guessCount) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner reader = new Scanner(new FileReader("assets/display" + guessCount + ".txt"))) {
            String line;
            while (reader.hasNext()) {
                line = reader.nextLine();
                stringBuilder.append(line).append("\n");
                printText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String asciiArt = stringBuilder.toString();
        String[] lines = asciiArt.split("\n");
        //int yOffset = (getHeight() - lines.length * TEXT_Y_OFFSET) / 2;

        textX = TEXT_X_OFFSET;
        textY = 0;

        for (int linesIt = 0; linesIt < lines.length; linesIt++) {
            printText(lines[linesIt]);
        }
        printText("Custom println()");
    }
    private static final int TEXT_Y_OFFSET = 20;   // you can modify this to suit your ascii art
    private static final int TEXT_X_OFFSET = 0;   // you can modify this to suit your ascii art
    private int textX;
    private int textY;

    public void printText(String text){
        GLabel line = new GLabel(text);
        add(line,  textX , textY );
        //add(line, 0, 20);
        line.setFont("Roboto-20");
        textY += TEXT_Y_OFFSET;
        System.out.println(text);
    }
    public void printText(String[] text){
        for (String str : text) {
            printText(str);
        }
    }
}

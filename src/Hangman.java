import acm.program.*;

public class Hangman extends ConsoleProgram {

    public void run() {
        // TODO: write this method
    }

    // TODO: comment this method
    private void intro() {
        // TODO: write this method
    }

    // TODO: comment this method
    private int playOneGame(String secretWord) {
        // TODO: write this method
        return 0;
    }


    // TODO: comment this method
    private String createHint(String secretWord, String guessedLetters) {
        // TODO: write this method
        return "";
    }

    // TODO: comment this method
    private char readGuess(String guessedLetters) {
        // TODO: write this method
        return '?';
    }

    // TODO: comment this method
    private void displayHangman(int guessCount) {
        // TODO: write this method
    }

    // TODO: comment this method
    private void stats(int gamesCount, int gamesWon, int best) {
        // TODO: write this method
    }

    // TODO: comment this method
    private String getRandomWord(String filename) {
        // TODO: write this method
        return "";
    }

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
        canvas.reset();  // sample canvas method call
        println("Hello LBYCPEI!");
        println("This is the next line!");
    }


    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Hangman().start(args);
    }


    // private HangmanCanvas canvas;
    private HangmanCanvas canvas;
}

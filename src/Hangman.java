import acm.program.ConsoleProgram;

import java.util.Scanner;

public class Hangman extends ConsoleProgram {
    private HangmanCanvas canvas;
    private static final int MAX_GUESSES = 8;
    private int gamesCount;
    private int gamesWon;
    private int best;

    public void run() {
        Scanner scan = new Scanner(System.in);
        intro();
        init(); // Call the init() method to instantiate the canvas object

        playOneGame("HELLOWORLD");
       stats(gamesCount, gamesWon, best);
    }
    // Runs the code
    private void intro() {
        printf("""
                ###################################
                        Welcome to Hangman!
                   I will think of a random word.
                   You'll try to guess its letters.
                    Every time you guess a letter
                  that isn't in my word, a new body
                   part of the hanging man appears.
                            Good luck!
                ###################################
                """);
    }
    // TODO: comment this method
    private int playOneGame(String secretWord) {
        canvas.resetHangman();
        int guessCount = MAX_GUESSES;
        String guessedLetters = "";

        while (guessCount > 0) {
            canvas.displayHangman(guessCount);
            println("Secret word: " + createHint(secretWord, guessedLetters));
            println("Your guesses: " + guessedLetters);
            println("Guesses left: " + guessCount);

            char guess = readGuess(guessedLetters);
            guessedLetters += guess;

            if (secretWord.indexOf(guess) != -1) {
                println("Correct!");
            } else {
                println("Incorrect.");
                guessCount--;
                canvas.resetHangman();
                canvas.displayHangman(guessCount);
            }
            String hint = createHint(secretWord, guessedLetters);
            if (hint.equals(secretWord)) {
                println("You guessed the word: " + secretWord);
                gamesWon++;
                break;
            }
        }
        if (guessCount == 0) {
            println("Sorry, you ran out of guesses. The word was: " + secretWord);
        }
        gamesCount++;
        if (gamesWon == 1 || guessCount > best) {
            best = guessCount;
        }
        return guessCount;
    }
    // TODO: comment this method
    private String createHint(String secretWord, String guessedLetters) {
        StringBuilder hint = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            char ch = secretWord.charAt(i);
            if (guessedLetters.indexOf(ch) != -1) {
                hint.append(ch);
            } else {
                hint.append("-");
            }
        }
        return hint.toString();
    }
    // TODO: comment this method
    private char readGuess(String guessedLetters) {
        while (true) {
            String input = readLine("Your guess? ");
            if (input.length() == 1) {
                char guess = Character.toUpperCase(input.charAt(0));
                if (!Character.isLetter(guess)) {
                    println("Invalid guess. Please enter a letter.");
                } else if (guessedLetters.indexOf(guess) != -1) {
                    println("You already guessed that letter.");
                } else {
                    return guess;
                }
            } else {
                println("Invalid guess. Please enter a single letter.");
            }
        }
    }
    // TODO: comment this method
    private void displayHangman(int guessCount) {
        canvas.displayHangman(guessCount);
    }
    // TODO: comment this method
    private void stats(int gamesCount, int gamesWon, int best) {
        printf("""
                #######################
                Game Statistics:
                Total games played: %d
                Games won: %d
                Best score: %d
                #######################
                """, gamesCount, gamesWon, best);
    }
    // TODO: comment this method
    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
        canvas.resetHangman();  // sample canvas method call
        println("Hello LBYCPEI!");
        println("This is the next line!");
    }
    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Hangman().start(args);
    }
}

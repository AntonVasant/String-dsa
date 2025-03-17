package LLD.game;
import java.util.*;

public class HangMan {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String word = "example"; // The word to guess
            Set<Character> guessedLetters = new HashSet<>();
            int maxWrongGuesses = 6;
            int wrongGuesses = 0;

            while (true) {
                // Display the current state of the word
                StringBuilder displayWord = new StringBuilder();
                boolean allGuessed = true;
                for (char c : word.toCharArray()) {
                    if (guessedLetters.contains(c)) {
                        displayWord.append(c).append(" ");
                    } else {
                        displayWord.append("_ ");
                        allGuessed = false;
                    }
                }
                System.out.println(displayWord.toString().trim());

                if (allGuessed) {
                    System.out.println("You won!");
                    break;
                }

                System.out.print("Guess a letter: ");
                char guess = scanner.nextLine().charAt(0);

                if (word.indexOf(guess) >= 0) {
                    guessedLetters.add(guess);
                } else {
                    wrongGuesses++;
                    System.out.println("Wrong guess! You have " + (maxWrongGuesses - wrongGuesses) + " guesses left.");
                }

                if (wrongGuesses >= maxWrongGuesses) {
                    System.out.println("You lost! The word was: " + word);
                    break;
                }
            }

            scanner.close();
        }
}


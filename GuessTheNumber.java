import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        System.out.println("Hello you! Welcome to the guessing game!");
        System.out.println("I will think of a number (0-10). You have unlimited attempts to guess and win.");
        int userNumber;
        int numberRange = 10;
        int randomNumber = randomNumberGenerator();
        String answer;

        for (int i = 1; i>0; i++) {
            do {
                do {
                    userNumber = userInput();
                    if (userNumber < 0 || userNumber > numberRange) {
                        System.out.println("Number out of range, please try again.");
                    }
                } while (userNumber < 0 || userNumber > numberRange);
                comparator(userNumber, randomNumber);
            } while (userNumber != randomNumber);

            randomNumber = randomNumberGenerator();

            do {
                answer = playAgain();
                    if (!(answer.equals("a") || answer.equals("b")))
                        System.out.println("Invalid answer. Please try again.");
            } while (!(answer.equals("a") || answer.equals("b")));

            if (answer.equals("b")) {
                    System.out.println("Thank you for the game. Bye.");
                    break;
                }
        }
    }

    public static String playAgain() {
        Scanner inAgain = new Scanner(System.in);
        System.out.println("Do you want to play again? Choose below: ");
        System.out.println("a: YES");
        System.out.println("b: NO");
        return inAgain.nextLine();

    }

    public static void comparator (int user, int random) {
        if (user == random) {
            System.out.println();
            System.out.println("Congratulations, you won!");

        } else if (user > random) {
            System.out.println("Your number is greater than mine.");
        } else {
            System.out.println("Your number is lower than mine.");
        }

    }
    public static  int randomNumberGenerator () {
        Random number = new Random();
        return number.nextInt(10);

    }
    public static int userInput () {
        Scanner userIn = new Scanner(System.in);
        System.out.println("Please enter your guess: ");
        return userIn.nextInt();

    }



}

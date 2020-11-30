package multiplicationgame;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class MultiplicationGame {

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();
    static int total = 0;
    static int incorrectTotal = 0;
    static int answer = 0;
    static int playersAnswer = 0;
    static String playAgain = null;
    static String name = null;
    static ArrayList<String> allNames = new ArrayList<>();
    static ArrayList<Integer> allTotals = new ArrayList<>();

    public static void main(String[] args) {
        boolean finished = false;

        while (finished == false) {
            total = 0;
            incorrectTotal = 0;
            System.out.println();
            System.out.println("Welcome to the multiplication game");
            System.out.println("Would you like to play?(again)");
            playAgain = input.next();

            if (playAgain.equalsIgnoreCase("n")) {
                finished = true;
                break;
            }

            System.out.println("There are 3 levels");
            System.out.println("LEVEL 1 = Easy maths");
            System.out.println("LEVEL 2 = Medium maths");
            System.out.println("LEVEL 3 = Hard maths");
            System.out.println("In all levels, you must get at least 8/10 questions correct \nto go to the next round");
            System.out.println("Are you ready?");
            System.out.println();
            System.out.println("Enter your name");
            String name = input.next();
            allNames.add(name);
            levelOne();

        }
    }

    public static void levelOne() {
        System.out.println("***** LEVEL ONE *****");
        for (int i = 1; i <= 10; i++) {
            int easyRandomOne = rand.nextInt(11);
            int easyRandomTwo = rand.nextInt(11);

            System.out.println("Question " + i + ": ");
            System.out.print(easyRandomOne + " x " + easyRandomTwo);
            answer = easyRandomOne * easyRandomTwo;
            System.out.println();
            System.out.println("What is your answer?");
            playersAnswer = input.nextInt();

            if (answer == playersAnswer) {
                System.out.println("Correct! Well done");
                System.out.println("10 points has been added to your total");
                total = total + 10;
                System.out.println("Your total is " + total);

                if ((i == 10) && (incorrectTotal < 2)) {
                    System.out.println("Well done! You have answered enough questions correctly to move on!");
                    System.out.println("Get ready for LEVEL TWO!");
                    levelTwo();
                }

            } else {
                System.out.println("Sorry, you are incorrect");
                System.out.println("The correct answer is " + answer);
                incorrectTotal++;
                System.out.println("You have got " + incorrectTotal + " wrong so far!");

            }
            if (incorrectTotal == 2) {
                System.out.println("Sorry you have answered 2 questions out of " + i + " incorrectly");
                loser();
                i = 11;
            }

        }
    }

    public static void levelTwo() {
        System.out.println("***** LEVEL TWO *****");
        incorrectTotal = 0;
        for (int i = 1; i <= 10; i++) {
            int mediumRandomOne = rand.nextInt((12 - 7) + 7) + 1;
            int mediumRandomTwo = rand.nextInt((12 - 7) + 7) + 1;

            System.out.println("Question " + i + ": ");
            System.out.print(mediumRandomOne + " x " + mediumRandomTwo);
            answer = mediumRandomOne * mediumRandomTwo;
            System.out.println();
            System.out.println("What is your answer?");
            playersAnswer = input.nextInt();

            if (answer == playersAnswer) {
                System.out.println("Correct! Well done");
                System.out.println("10 points has been added to your total");
                total = total + 10;
                System.out.println("Your total is " + total);

                if ((i == 10) && (incorrectTotal < 2)) {
                    System.out.println("Well done! You have answered enough questions correctly to move on!");
                    System.out.println("Get ready for LEVEL THREE!");
                    levelThree();

                }
            } else {
                System.out.println("Sorry, you are incorrect");
                System.out.println("The correct answer is " + answer);
                incorrectTotal++;
                System.out.println("You have got " + incorrectTotal + " wrong so far!");

            }
            if (incorrectTotal == 2) {
                System.out.println("You have answered 2 questions out of " + i + " incorrectly");
                loser();
                i = 11;
            }

        }
    }

    public static void levelThree() {
        System.out.println("***** LEVEL THREE *****");
        incorrectTotal = 0;
        for (int i = 1; i <= 10; i++) {
            int hardRandomOne = rand.nextInt((15 - 10) + 10) + 1;
            int hardRandomTwo = rand.nextInt((15 - 10) + 10) + 1;

            System.out.println("Question " + i + ": ");
            System.out.print(hardRandomOne + " x " + hardRandomTwo);
            answer = hardRandomOne * hardRandomTwo;
            System.out.println();
            System.out.println("What is your answer?");
            playersAnswer = input.nextInt();

            if (answer == playersAnswer) {
                System.out.println("Correct! Well done");
                System.out.println("10 points has been added to your total");
                total = total + 10;
                System.out.println("Your total is " + total);

                if ((i == 10) && (incorrectTotal < 2)) {
                    winner();

                }
            } else {
                System.out.println("Sorry, you are incorrect");
                System.out.println("The correct answer is " + answer);
                incorrectTotal++;
                System.out.println("You have got " + incorrectTotal + " wrong so far!");

            }
            if (incorrectTotal == 2) {
                System.out.println("You have answered 2 questions out of " + i + " incorrectly");
                loser();
                i = 11;
            }

        }
    }

    public static void winner() {
        allTotals.add(total);
        System.out.println("CONGRATULATIONS! You have won the multiplication game!");
        System.out.println("You have collected a total of " + total + " points!");
        System.out.println("Well done!");
        System.out.println("The leaderboard is as follows:");
        leaderBoard();

    }

    public static void loser() {
        allTotals.add(total);
        System.out.println("SORRY! You have lost the multiplication game!");
        System.out.println("You have collected a total of " + total + " points!");
        System.out.println("Better luck next time!");
        System.out.println("The leaderboard is as follows:");
        leaderBoard();

    }

    public static void leaderBoard() {
        System.out.println("-----LEADERBOARD-----");

        for (int i = 0; i < allNames.size(); i++) {
            System.out.println((allNames.get(i)) + " " + (allTotals.get(i)));
        }

    }

}


    


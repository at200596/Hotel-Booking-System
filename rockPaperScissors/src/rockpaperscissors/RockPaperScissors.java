package rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        boolean finished = false;
        String[] choices = new String[3];
        choices[0] = "Rock";
        choices[1] = "Paper";
        choices[2] = "Scissors";

        int max = 2;
        int min = 0;
        

        while (finished == false) {
            int playersTotal = 0;
            int computersTotal = 0;
            System.out.println("Lets play rock, paper, scissors");
            System.out.println("Enter your name please");
            String name = input.next();

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter your play");
                System.out.println();
                String playersChoice = input.next();
                
                int random = rand.nextInt((max - min) + min) + 1;
                String computersChoice = choices[random];

                if (playersChoice.equalsIgnoreCase("rock")) {
                    if (computersChoice.equalsIgnoreCase("rock")) {
                        System.out.println("I played rock too!");
                        System.out.println("Its a tie");
                        System.out.println("No points are won this round!");
                        System.out.println(name + "'s total is: " + playersTotal);
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }
                    if (computersChoice.equalsIgnoreCase("paper")) {
                        System.out.println("I played paper!");
                        System.out.println("Paper beats rock!");
                        System.out.println("I gain a 10 points mwahaha");
                        System.out.println(name + "'s total is: " + playersTotal);
                        computersTotal = computersTotal + 10;
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }
                    if (computersChoice.equalsIgnoreCase("scissors")) {
                        System.out.println("I played scissors!");
                        System.out.println("Rock beats scissors!");
                        System.out.println("You gain 10 points!");
                        playersTotal = playersTotal + 10;
                        System.out.println(name + "'s total is: " + playersTotal);
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }

                } else if (playersChoice.equalsIgnoreCase("paper")) {
                    if (computersChoice.equalsIgnoreCase("paper")) {
                        System.out.println("I played paper too!");
                        System.out.println("Its a tie");
                        System.out.println("No points are won this round!");
                        System.out.println(name + "'s total is: " + playersTotal);
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }
                    if (computersChoice.equalsIgnoreCase("scissors")) {
                        System.out.println("I played scissors!");
                        System.out.println("Scissors beats paper!");
                        System.out.println("I gain a 10 points mwahaha");
                        System.out.println(name + "'s total is: " + playersTotal);
                        computersTotal = computersTotal + 10;
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }
                    if (computersChoice.equalsIgnoreCase("rock")) {
                        System.out.println("I played rock!");
                        System.out.println("Paper beats rock!");
                        System.out.println("You gain 10 points!");
                        playersTotal = playersTotal + 10;
                        System.out.println(name + "'s total is: " + playersTotal);
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }

                } else if (playersChoice.equalsIgnoreCase("scissors")) {
                    if (computersChoice.equalsIgnoreCase("scissors")) {
                        System.out.println("I played scissors too!");
                        System.out.println("Its a tie");
                        System.out.println("No points are won this round!");
                        System.out.println(name + "'s total is: " + playersTotal);
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }
                    if (computersChoice.equalsIgnoreCase("rock")) {
                        System.out.println("I played Rock!");
                        System.out.println("Rock beats Scissors!");
                        System.out.println("I gain a 10 points mwahaha");
                        System.out.println(name + "'s total is: " + playersTotal);
                        computersTotal = computersTotal + 10;
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }
                    if (computersChoice.equalsIgnoreCase("paper")) {
                        System.out.println("I played paper!");
                        System.out.println("Scissors beats Paper!");
                        System.out.println("You gain 10 points!");
                        playersTotal = playersTotal + 10;
                        System.out.println(name + "'s total is: " + playersTotal);
                        System.out.println("My total is: " + computersTotal);
                        System.out.println();
                    }
                    

                }else{
                    System.out.println("You have entered an invalid answer");
                    i--;
                }
                
                
            }
        
            System.out.println("=========BONUS ROUND=========");
            System.out.println("QUICK! I'm thinking of a number between 1-5");
            System.out.println("If you guess it, you win an extra 10 points!");
            System.out.println("Enter your guess");
            int numberGuessed = input.nextInt();
            
            int randomNumber = rand.nextInt((5-1)+1)+1;
            
            if(numberGuessed == randomNumber){
                System.out.println("WELL DONE!");
                System.out.println("You have guessed my number");
                System.out.println("An extra 10 points to you!");
                playersTotal = playersTotal + 10;
            }else{
                System.out.println("Sorry :( Better luck next time");
                
            }
            
            System.out.println();
            System.out.println("Wow what a game");
            System.out.println("The total scores are:");
            System.out.println(name+" : " + playersTotal);
            System.out.println("Computer : " + computersTotal);
            System.out.println();

            if (playersTotal > computersTotal) {
                System.out.println("Congratulations!");
                System.out.println("You beat me by " + (playersTotal - computersTotal) + " points!");

            } else if(computersTotal > playersTotal){
                System.out.println("Sorry to say this, but I won!");
                System.out.println("I beat you by " + (computersTotal - playersTotal) + " points!");

            }else{
                System.out.println("Its a tie!");
                System.out.println("I guess we can share the win....");
            }
            System.out.println();
            System.out.println("Would you like to play again? (Y/N)");
            String answer = input.next();

            if (answer.equalsIgnoreCase("y")) {
                finished = false;

            } else {
                finished = true;
            }
            
        }
            
       

    }

}

package hotelbookingsystem;

import java.util.Scanner;

public class HotelBookingSystem {

    static Scanner input = new Scanner(System.in);
//    private static ArrayList<HotelBookingSystem> bookings = new ArrayList<>();

    static int total = 0;
    static int numberOfDays = 0;
    static String roomType;
    static String boardOfRoom;
    static int fullDiscountTotal = 0;
    static int fullNormalTotal = 0;
    static String surname;
    static boolean done = false;
    static int m = 0;

    static String[] reservations = new String[15];

    public static void main(String[] args) {

        while (done == false) {

            System.out.println("Hello, Welcome to Ailise's Hotel");
            System.out.println("There are currently " + (15-m) + " rooms available");
            System.out.println("How can I help you today?");
            System.out.println("1 - Book a room");
            System.out.println("2 - View rooms taken");
            System.out.println("3 - Finish");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    bookingRoom();
                    break;
                case 2:
                    viewingRoom();
                    break;
                case 3:
                    done = true;
                    break;

            }

        }
    }

    public static void bookingRoom() {
        if(m == 14){
            System.out.println("Sorry! We are completely booked for the next couple of days");
            System.out.println("Come back soon and see if there are any openings!");
        }
        
        
        System.out.println("");
        System.out.println("Welcome to booking a room");
        System.out.println("How many rooms would you like to book?");
        int numberOfRooms = input.nextInt();

        for (int i = 0; i < numberOfRooms; i++) {
            total = 0;
            System.out.println("What type of room would you like? (" + i + ")");
            System.out.println("1 - Single(1) , £50");
            System.out.println("2 - Double(2) , £75");
            System.out.println("3 - Family(4) , £105");
            int typeOfRoom = input.nextInt();

            switch (typeOfRoom) {
                case 1:
                    roomType = "Single";
                    total = total + 50;
                    break;
                case 2:
                    roomType = "Double";
                    total = total + 75;
                    break;
                case 3:
                    roomType = "Family";
                    total = total + 105;
                    break;

            }

            System.out.println("What type of board do you wish to have?");
            System.out.println("1 - Self-Catering , £0");
            System.out.println("2 - Half-Board , £10");
            System.out.println("3 - Full Board , £20");
            int userChoice = input.nextByte();

            switch (userChoice) {
                case 1:
                    boardOfRoom = "Self-Catering";
                    total = total + 0;
                    break;
                case 2:
                    boardOfRoom = "Half-Board";
                    total = total + 10;
                    break;
                case 3:
                    boardOfRoom = "Full Board";
                    total = total + 20;
                    break;
            }

            System.out.println("How many days are you planning on staying?");
            numberOfDays = input.nextInt();

            if (numberOfDays > 7) {
                System.out.println("Great! You qualify for our daily discount");

                calculatingTotal();

                System.out.println("Your normal total would have come to " + "£" + fullNormalTotal);
                System.out.println("Your full discount total comes to " + "£" + fullDiscountTotal);
                System.out.println("You saved a total of " + "£" + (fullNormalTotal - fullDiscountTotal));

            } else {
                System.out.println("I'm afraid you do not qualify for our discount");
                calculatingTotal();
                System.out.println("Your full total comes to " + "£" + fullNormalTotal);

            }

            System.out.println("Finally, can I get a surname for this room please");
            surname = input.next();

            System.out.println();
            System.out.println("Great, Thank you for booking a room at Ailise's Hotel");
            System.out.println("Your details are as shown:");
            System.out.println();
            System.out.println("Name: " + surname);
            System.out.println("Room Type: " + roomType);
            System.out.println("Board Type: " + boardOfRoom);

            if (fullDiscountTotal == 0) {
                System.out.println("Total Payment: " + "£" + fullNormalTotal);
                reservations[m] = surname + " , " + roomType + " , " + boardOfRoom + " , " + "£" + fullNormalTotal;
                m++;
            } else {
                System.out.println("Total Payment: " + "£" + fullDiscountTotal);
                reservations[m] = surname + " , " + roomType + " , " + boardOfRoom + " , " + "£" + fullDiscountTotal;
                m++;
            }
            System.out.println();

            //store all details in object/array
        }

    }

    public static void viewingRoom() {
        System.out.println("These are the rooms booked");
        for (int i = 0; i < 15; i++) {

            System.out.println(reservations[i]);

        }

    }

    public static void calculatingTotal() {
        int discountPrice = 0;
        if (numberOfDays > 7) {
            int discountDays = numberOfDays - 7;

            for (int i = discountDays; i > 0; i--) {

                if ((boardOfRoom.equals("Self-Catering"))) {
                    if (roomType.equals("Single")) {
                        discountPrice = discountPrice + 40;

                    } else if (roomType.equals("Double")) {
                        discountPrice = discountPrice + 60;

                    } else if (roomType.equals("Family")) {
                        discountPrice = discountPrice + 84;
                    }

                } else if (boardOfRoom.equals("Half-Board")) {
                    if (roomType.equals("Single")) {
                        discountPrice = discountPrice + 48;
                    } else if (roomType.equals("Double")) {
                        discountPrice = discountPrice + 68;
                    } else if (roomType.equals("Family")) {
                        discountPrice = discountPrice + 92;
                    }

                } else if (boardOfRoom.equals("Full Board")) {
                    if (roomType.equals("Single")) {
                        discountPrice = discountPrice + 56;
                    } else if (roomType.equals("Double")) {
                        discountPrice = discountPrice + 76;
                    } else if (roomType.equals("Family")) {
                        discountPrice = discountPrice + 100;
                    }

                }
            }

            fullDiscountTotal = (total * 7) + discountPrice;
            fullNormalTotal = total * numberOfDays;

        }
        fullNormalTotal = total * numberOfDays;

    }

}

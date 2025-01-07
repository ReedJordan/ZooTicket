import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the 2024 Christmas Zoo Lights!");
        System.out.println("After getting your ticket, please type -1 to quit, or any other number to continue.");
        int userWantsOut = 0;

        String[][] driveInArray = new String[100][6];
        int driveTicketNum = 0;

        String[][] walkInArray = new String[100][8];
        int walkTicketNum = 0;
        int randomNum = 5;

        while (userWantsOut != -1) {
            System.out.println("Do you want to purchase a ticket, or lookup a ticket? (purchase 1, lookup 2)");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Do you want to drive through or walk in? (drive 1, walk 2)");
                int buyerInput = scanner.nextInt();
                if (buyerInput == 1) {
                    driveInArray = driveInTicket(driveInArray, driveTicketNum);
                    driveTicketNum++;
                } else if (buyerInput == 2) {
                    walkInArray = walkInTicket(walkInArray, walkTicketNum, randomNum);
                    walkTicketNum++;
                }
            } else if (input == 2) {
                System.out.println("Do you want to look up a drive through ticket or a walk in ticket? (drive 1, walk 2)");
                int lookingInput = scanner.nextInt();
                if (lookingInput == 1) {
                    System.out.println("What is the ticket ID?");
                    int givenDriveNum = scanner.nextInt();
                    int neededNumber = findTicketIndex(driveInArray, givenDriveNum);

                    if (neededNumber != -1) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Name: " + driveInArray[neededNumber][0]);
                        System.out.println("Date of Birth: " + driveInArray[neededNumber][1]);
                        System.out.println("Member: " + driveInArray[neededNumber][2]);
                        System.out.printf("Price: %.2f", Double.parseDouble(driveInArray[neededNumber][3]));
                        System.out.println("\nDate of attendance: " + driveInArray[neededNumber][4]);
                        System.out.println("Ticket Number: " + driveInArray[neededNumber][5]);
                        System.out.println("D R I V E T H R O U G H T I C K E T");
                        System.out.println("-------------------------------------------");
                    } else {
                        System.out.println("Ticket not found.");
                    }
                } else if (lookingInput == 2) {
                    System.out.println("What is the ticket ID?");
                    int givenWalkNum = scanner.nextInt();
                    int needWalkNumber = findTicketIndex(walkInArray, givenWalkNum);

                    if (needWalkNumber != -1) {
                        System.out.println("----------------------------------");
                        System.out.println("Name: " + walkInArray[needWalkNumber][0]);
                        System.out.println("Date of Birth: " + walkInArray[needWalkNumber][1]);
                        System.out.println("Member: " + walkInArray[needWalkNumber][2]);
                        System.out.printf("Price: %.2f", Double.parseDouble(walkInArray[needWalkNumber][3]));
                        System.out.println("\nDate of attendance: " + walkInArray[needWalkNumber][4]);
                        System.out.println("Train eligible: " + walkInArray[needWalkNumber][5]);
                        System.out.println("Drink eligible: " + walkInArray[needWalkNumber][6]);
                        System.out.println("Ticket Number: " + walkInArray[needWalkNumber][7]);
                        System.out.println("W A L K I N T I C K E T");
                        System.out.println("----------------------------------");
                    } else {
                        System.out.println("Ticket not found.");
                    }
                }
            }

            userWantsOut = scanner.nextInt();
        }
    }

    public static String[][] driveInTicket(String[][] storeArr, int partID) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int numPeople = 0;
        String driverName = "";
        boolean member = false;
        int bornMonth = 0;
        int bornDay = 0;
        int bornYear = 0;
        boolean isWeek = false;
        double price = 65;
        int ticketNumber = 10000 + rand.nextInt(90000);
        String realNumber = String.valueOf(ticketNumber);

        System.out.println("How many people are you taking?");
        numPeople = input.nextInt();
        input.nextLine();
        System.out.println("What is your name? First and last.");
        driverName = input.nextLine();
        System.out.println("Which date do you want to see the lights? (MM/dd/yyyy)");
        String dateInput = input.nextLine();
        LocalDate attendDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        DayOfWeek dayOfWeek = attendDate.getDayOfWeek();
        String visitDate = attendDate.toString();
        System.out.println("Do you have a membership? (y/n)");
        String memAnswer = input.nextLine();
        if (memAnswer.equals("y")) {
            System.out.println("What is your membership code?");
            String memCode = input.nextLine();
            if (memCode.equals("MEMBER")) {
                member = true;
            }
        }
        System.out.println("When were you born? (mm/dd/yyyy format)");
        String birthday = input.nextLine();

        if (numPeople > 8) {
            price = price + (12 * (numPeople - 8));
        }
        if (member) {
            price = price * .8;
        }
        System.out.println("-------------------------------------------");
        System.out.println("Name: " + driverName);
        System.out.println("Date of Birth: " + birthday);
        System.out.println("Member: " + member);
        System.out.printf("Price: %.2f", price);
        System.out.println("\nDate of attendance: " + visitDate);
        System.out.println("Day of the week: " + dayOfWeek);
        System.out.println("Ticket Number: " + realNumber);
        System.out.println("D R I V E T H R O U G H T I C K E T");
        System.out.println("-------------------------------------------");

        storeArr[partID][0] = driverName;
        storeArr[partID][1] = birthday;
        storeArr[partID][2] = String.valueOf(member);
        storeArr[partID][3] = String.valueOf(price);
        storeArr[partID][4] = visitDate;
        storeArr[partID][5] = realNumber;

        return storeArr;
    }

    public static String[][] walkInTicket(String[][] arrStore, int partialID, int randLOL) {
        //TODO: fix the WalkInTicket lookup
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String walkerName = "";
        boolean member = false;
        int bornMonth = 0;
        int bornDay = 0;
        int bornYear = 0;
        int age = 0;
        boolean tallEnough = false;
        boolean lightEnough = false;
        boolean trainRider = false;
        boolean canDrink = false;
        boolean isWeek = false;
        int ticketNumber = 10000 + rand.nextInt(90000);
        String trueNumber = String.valueOf(ticketNumber);

        double price = 0;

        System.out.println("What is your name? First and last.");
        walkerName = input.nextLine();
        System.out.println("Which date do you want to see the lights? (MM/dd/yyyy)");
        String dateInput = input.nextLine();
        LocalDate attendDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        DayOfWeek dayOfWeek = attendDate.getDayOfWeek();
        String visitDay = dayOfWeek + ", " + attendDate.toString();

        System.out.println("Do you have a membership? (y/n)");
        String memAnswer = input.nextLine();
        if (memAnswer.equals("y")) {
            System.out.println("What is your membership code?");
            String memCode = input.nextLine();
            if (memCode.equals("MEMBER")) {
                member = true;
            }
        }

        System.out.println("When were you born? (mm/dd/yyyy format)");
        String birthday = input.nextLine();

        age = Period.between(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("MM/dd/yyyy")), LocalDate.of(2024, 12, 25)).getYears();
        if (age >= 21) {
            canDrink = true;
        }

        if (age >= 18) {
            if (isWeek) {
                price = 16;
            } else {
                price = 25;
            }
        } else if (15 <= age && age < 18) {
            if (isWeek) {
                price = 12;
            } else {
                price = 18;
            }
        } else if (2 <= age && age < 15) {
            if (isWeek) {
                price = 8;
            } else {
                price = 12;
            }
        } else if (age < 2) {
            price = 0;
        }
        if (member) {
            price = price * 0.8;
        }

        System.out.println("Are you taller than 4 feet? (yes/no)");
        String heightAnsw = input.nextLine();
        if (heightAnsw.equals("yes") || heightAnsw.equals("Yes")) {
            tallEnough = true;
        }
        System.out.println("Are you lighter than 300 lbs? (yes/no)");
        String weightAnsw = input.nextLine();
        if (weightAnsw.equals("yes") || weightAnsw.equals("Yes")) {
            lightEnough = true;
        }
        if (tallEnough && lightEnough) {
            trainRider = true;
        }

        System.out.println("\n");
        System.out.println("----------------------------------");
        System.out.println("Name: " + walkerName);
        System.out.println("Date of Birth: " + birthday);
        System.out.println("Member: " + member);
        System.out.printf("Price: %.2f", price);
        System.out.println("\nDate of attendance: " + visitDay);
        System.out.println("Train eligible: " + trainRider);
        System.out.println("Drink eligible: " + canDrink);
        System.out.println("Ticket Number: " + trueNumber);
        System.out.println("W A L K I N T I C K E T");
        System.out.println("----------------------------------");

        arrStore[partialID][0] = walkerName;
        arrStore[partialID][1] = birthday;
        arrStore[partialID][2] = String.valueOf(member);
        arrStore[partialID][3] = String.valueOf(price);
        arrStore[partialID][4] = visitDay;
        arrStore[partialID][5] = String.valueOf(trainRider);
        arrStore[partialID][6] = String.valueOf(canDrink);
        arrStore[partialID][7] = trueNumber;

        return arrStore;
    }

    public static int findTicketIndex(String[][] arr, int ticketNumber) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][5] != null && arr[i][5].equals(String.valueOf(ticketNumber))) {
                return i;
            }
        }
        return -1;
    }
}
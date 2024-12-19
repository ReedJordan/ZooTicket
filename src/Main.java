import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the 2024 Christmas Zoo Lights!");

        //stuff for drive through array:
        String[][] driveInArray = new String[100][6]; //stores 100 tickets
        int driveTicketNum = 0;

        //stuff for walk in array:
        String[][] walkInArray = new String[100][8]; //stores 100 tickets
        int walkTicketNum = 0;
        int randomNum = 5;

        System.out.println("Do you want to purchase a ticket, or lookup a ticket? (purchase 1, lookup 2)");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1){
            System.out.println("Do you want to drive through or walk in? (drive 1, walk 2)");
            int buyerInput = scanner.nextInt();
            if(buyerInput == 1){
                driveInArray = driveInTicket(driveInArray, driveTicketNum);
                driveTicketNum++;
            } else if(buyerInput == 2){
                walkInArray = walkInTicket(walkInArray, walkTicketNum, randomNum);
                walkTicketNum++;
            }
        } else if(input == 2){
            System.out.println("Do you want to look up a drive through ticket or a walk in ticket? (drive 1, walk 2)");
            int lookingInput = scanner.nextInt();
            if(lookingInput == 1){

            }else if (lookingInput == 2){

            }
        }
    }

    public static String[][] driveInTicket(String[][] storeArr, int partID){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();


        int numPeople = 0;
        String driverName = "";
        boolean member = false;
        int attendMonth = 12;
        int attendDay = 0;
        int attendYear = 2024;
        int bornMonth = 0;
        int bornDay = 0;
        int bornYear = 0;
        boolean isWeek = false;
        double price = 65;
        int ticketNumber = rand.nextInt(1000);
        String realNumber = (partID * 1000) + ticketNumber +" ";

        System.out.println("How many people are you taking?");
        numPeople = input.nextInt();
        System.out.println("What is your name? First and last.");
        driverName = input.nextLine();
        driverName = input.nextLine();
        System.out.println("Which december day do you want to see the lights?");
        attendDay = input.nextInt();
        String visitDate = "12/"+ attendDay +"/2024";
        System.out.println("Do you have a membership? (y/n)");
        String memAnswer = input.nextLine();
        memAnswer = input.nextLine();
        if (memAnswer.equals("y")){
            System.out.println("What is your membership code?");
            String memCode = input.nextLine();
            if (memCode.equals("MEMBER")){
                member = true;
            }
        }
        System.out.println("When were you born? (mm/dd/yyyy format)");
        bornMonth = input.nextInt();
        System.out.println("/ ");
        bornDay = input.nextInt();
        System.out.println("/ ");
        bornYear = input.nextInt();
        String birthday = bornMonth +"/"+ bornDay +"/"+ bornYear;

        if (numPeople > 8) {
            price = price + (12 * (numPeople - 8));
        }
        if (member){
            price = price*.8;
        }
        System.out.println("-------------------------------------------");
        System.out.println("Name: "+ driverName);
        System.out.println("Date of Birth: "+ birthday);
        System.out.println("Member: "+ member);
        System.out.printf("Price: %.2f", price);
        System.out.println("\nDate of attendance: "+ visitDate);
        System.out.println("Ticket Number: "+ realNumber);
        System.out.println("D R I V E T H R O U G H T I C K E T");
        System.out.println("-------------------------------------------");

        storeArr[partID][0] = driverName;
        storeArr[partID][1] = birthday;
        String isMember = member +" ";
        storeArr[partID][2] = isMember;
        String ticketPrice = price +" ";
        storeArr[partID][3] = ticketPrice;
        storeArr[partID][4] = visitDate;
        storeArr[partID][5] = realNumber;

        return storeArr;

    }


    public static String[][] walkInTicket(String[][] arrStore, int partialID, int randLOL){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        
        String walkerName = "";
        boolean member = false;
        int attendMonth = 12;
        int attendDay = 0;
        int attendYear = 2024;
        int bornMonth = 0;
        int bornDay = 0;
        int bornYear = 0;
        int age = 0;
        boolean tallEnough = false;
        boolean lightEnough = false;
        boolean trainRider = false;
        boolean canDrink = false;
        String dayOfWeek = "";
        boolean isWeek = false;
        int ticketNumber = rand.nextInt(1000);
        String trueNumber = (partialID * 1000) + ticketNumber +" ";
        
        double price = 0;

        System.out.println("What is your name? First and last.");
        walkerName = input.nextLine();
        System.out.println("Which december day do you want to see the lights?");
        attendDay = input.nextInt();
        if(attendDay == 1 || attendDay == 8 || attendDay == 15 || attendDay == 22 || attendDay == 29){
            dayOfWeek = "Sunday";
        }else if (attendDay == 2 || attendDay == 9 || attendDay == 16 || attendDay == 23 || attendDay == 30){
            dayOfWeek = "Monday";
            isWeek = true;
        }else if (attendDay == 3 || attendDay == 10 || attendDay == 17 || attendDay == 24 || attendDay == 31){
            dayOfWeek = "Tuesday";
            isWeek = true;
        }else if (attendDay == 4 || attendDay == 11 || attendDay == 18 || attendDay == 25){
            dayOfWeek = "Wednesday";
            isWeek = true;
        }else if (attendDay == 5 || attendDay == 12 || attendDay == 19 || attendDay == 26){
            dayOfWeek = "Thursday";
            isWeek = true;
        }else if (attendDay == 6 || attendDay == 13 || attendDay == 20 || attendDay == 27){
            dayOfWeek = "Friday";
            isWeek = true;
        }else if (attendDay == 7 || attendDay ==  14|| attendDay == 21 || attendDay == 28){
            dayOfWeek = "Saturday";
        }
        String visitDay = dayOfWeek +", 12/"+ attendDay +"/2024";
        
        
        System.out.println("Do you have a membership? (y/n)");
        String memAnswer = input.nextLine();
        memAnswer = input.nextLine();
        if (memAnswer.equals("y")){
            System.out.println("What is your membership code?");
            String memCode = input.nextLine();
            if (memCode.equals("MEMBER")){
                member = true;
            }
        }
        String amMember = member +" ";
        
        System.out.println("When were you born? (mm/dd/yyyy format)");
        bornMonth = input.nextInt();
        System.out.println("/ ");
        bornDay = input.nextInt();
        System.out.println("/ ");
        bornYear = input.nextInt();
        String birthday = bornMonth +"/"+ bornDay +"/"+ bornYear;
        System.out.println("Will you be 21 or older by the date you plan to attend? (yes/no)");
        String drinkAnswer = input.nextLine();
        drinkAnswer = input.nextLine();
        if(drinkAnswer.equals("yes") || drinkAnswer.equals("Yes")){
            canDrink = true;
        }
        
        age = 2024 - bornYear;
        if(age >= 18){
            if(isWeek){
                price = 16;
            }else if (!isWeek){
                price = 25;
            }
        }else if (15 <= age && age < 18){
            if(isWeek){
                price = 12;
            }else if (!isWeek){
                price = 18;
            }
        }else if (2 <= age && age < 15){
            if(isWeek){
                price = 8;
            }else if (!isWeek){
                price = 12;
            }
        }else if (age < 2){
            price = 0;
        }
        if(member){
            price = price * 0.8;
        }
        
        System.out.println("Are you taller than 4 feet? (yes/no)");
        String heightAnsw = input.nextLine();
        if(heightAnsw.equals("yes") || heightAnsw.equals("Yes")){
            tallEnough = true;
        }
        System.out.println("Are you lighter than 300 lbs? (yes/no)");
        String weightAnsw = input.nextLine();
        if(weightAnsw.equals("yes") || weightAnsw.equals("Yes")){
            lightEnough = true;
        }
        if(tallEnough && lightEnough){
            trainRider = true;
        }
        
        
        System.out.println("\n");
        System.out.println("----------------------------------");
        System.out.println("Name: "+ walkerName);
        System.out.println("Date of Birth: "+ birthday);
        System.out.println("Member: "+ amMember);
        System.out.printf("Price: %.2f", price);
        System.out.println("\nDate of attendance: "+ visitDay);
        System.out.println("Train eligible: "+ trainRider);
        System.out.println("Drink eligible: "+ canDrink);
        System.out.println("Ticket Number: "+ trueNumber);
        System.out.println("W A L K I N T I C K E T");
        System.out.println("----------------------------------");
        

        arrStore[partialID][0] = walkerName;
        arrStore[partialID][1] = birthday;
        arrStore[partialID][2] = amMember;
        String goodPrice = price +" ";
        arrStore[partialID][3] = goodPrice;
        arrStore[partialID][4] = visitDay;
        String canRide = trainRider +" ";
        arrStore[partialID][5] = canRide;
        String drinkThirsty = canDrink +" ";
        arrStore[partialID][6] = drinkThirsty;
        arrStore[partialID][7] = trueNumber;

        return arrStore;

    }
}

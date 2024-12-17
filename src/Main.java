import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the 2024 Christmas Zoo Lights!");
        System.out.println("Do you want to purchase a ticket, or lookup a ticket? (purchase 1, lookup 2)");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input == 1){
            System.out.println("Do you want to drive through or walk in? (drive 1, walk 2)");
            input = scanner.nextInt();
            if(input == 1){
                driveInTicket();
            } else if(input == 2){
                walkInTicket();
            }
        } else if(input == 2){
        }
    }

    public static void driveInTicket(){
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
        int ticketNumber = rand.nextInt(100000);

        System.out.println("How many people are you taking?");
        numPeople = input.nextInt();
        System.out.println("What is your name? First and last.");
        driverName = input.nextLine();
        driverName = input.nextLine();
        System.out.println("Which december day do you want to see the lights?");
        attendDay = input.nextInt();
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

        if (numPeople > 8) {
            price = price + (12 * (numPeople - 8));
        }
        if (member){
            price = price*.8;
        }
        System.out.println("-------------------------------------------");
        System.out.println("Name: "+ driverName);
        System.out.println("Date of Birth: "+ bornMonth +"/"+ bornDay +"/"+ bornYear);
        System.out.println("Member: "+ member);
        System.out.printf("Price: %.2f", price);
        System.out.println("\nDate of attendance: 12/"+ attendDay +"/2024");
        System.out.println("Ticket Number: "+ ticketNumber);
        System.out.println("D R I V E T H R O U G H T I C K E T");
        System.out.println("-------------------------------------------");
    }

    public static void walkInTicket(){
        boolean member = false;
        int attendMonth = 12;
        int attendDay = 0;
        int attendYear = 2024;
        int bornMonth = 0;
        int bornDay = 0;
        int bornYear = 0;
        int height = 0;
        int weight = 0;
        boolean trainRider = false;
        boolean isWeek = false;
        //TODO: finish walk through

    }
}
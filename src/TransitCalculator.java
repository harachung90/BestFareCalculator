import java.util.Scanner;

public class TransitCalculator {

    int numDays;
    int numRides;

    double singleRideFare = 2.75;
    double sevenDayUnlimitedFare = 33.00;
    double thirtyDayUnlimitedFare = 127.00;

    public double unlimited7Price() {
        int amount7Pass = numDays / 7;
        if (numDays % 7 != 0) {
            amount7Pass += 1;
        }

        double singleFare = Math.ceil(sevenDayUnlimitedFare * amount7Pass / numRides);
        return singleFare;
    }

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("How many days are you going to using the transit system?");
        int numDays = myObj.nextInt();  // Read user input
        System.out.println("You'll be using the transit system for "+ numDays +" day(s).");  // Output user input

        System.out.println("How many rids are you going to take during that time?");
        int numRides = myObj.nextInt();  // Read user input
        System.out.println("You'll be using the transit system for " + numRides + " ride(s).");  // Output user input
        myObj.close();



    }
}
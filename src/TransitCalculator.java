import java.util.Scanner;

public class TransitCalculator {

    int numDays;
    int numRides;

    String[] fareOptions = {"Pay-per-ride", "7-Day Unlimited", "30-Day Unlimited"};
    double[] fares = {2.75, 33.00, 127.00};

    public TransitCalculator(int days, int rides) {
        numDays = days;
        numRides = rides;
    }

    public double unlimited7Price() {

        double sevenDayPurchases = Math.ceil(numDays / 7.0);
        double totalCost = Math.ceil(fares[1] * sevenDayPurchases);

        return totalCost / numRides;
    }

    public double[] getRidePrices() {

        double payPerRidePrice = fares[0];
        double unlimited7Price = unlimited7Price();
        double unlimited30Price = fares[2] / numRides;

        double[] prices = {payPerRidePrice, unlimited7Price, unlimited30Price};

        return prices;
    }

    public String getBestFare() {

        double[] ridePrices = getRidePrices();
        int theIndex = 0;

        for (int i = 0; i < ridePrices.length; i++) {
            if (ridePrices[i] < ridePrices[theIndex]) {
                theIndex = i;
            }

        }
        return "You should get " + fareOptions[theIndex] + " option at $" + Math.round(ridePrices[theIndex] * 100.0) / 100.0 + " per ride.";
    }

    public static void main(String[] args) {

        int myDays = 5;
        int myRides = 12;

        TransitCalculator trip1 = new TransitCalculator(myDays, myRides);

        System.out.println(trip1.getBestFare());

    }
}
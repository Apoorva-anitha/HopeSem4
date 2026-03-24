import java.util.*;
public class CountOdds {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter low: ");
        int low = sc.nextInt();

        System.out.print("Enter high: ");
        int high = sc.nextInt();

        // Optimized formula
        int result = (high + 1) / 2 - low / 2;

        System.out.println("Number of odd numbers: " + result);

        sc.close();
    }
}
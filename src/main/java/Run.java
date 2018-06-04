
import java.util.Scanner;

public class Run {

    private static Purchase purchase;
    private static final String SCAN_PRODUCT = "1";
    private static final String EXIT = "2";

    public static void main(String[] args) {
        purchase = new Purchase();
        makeDecision();
    }

    private static void makeDecision() {
        System.out.println("press 1 to scan product or 2 to exit");
        String choice = inputChoice();
        if (choice.equals(SCAN_PRODUCT)) {
            System.out.println("Input code: ");
            purchase.scanProduct(inputChoice());
            makeDecision();
        } else if (choice.equals(EXIT)) purchase.exit();
        else {
            System.out.println("incorrect input");
            makeDecision();
        }
    }

    private static String inputChoice() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

}

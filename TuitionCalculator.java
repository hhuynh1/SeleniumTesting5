import java.util.Scanner;

public class TuitionCalculator {

    public static void main(String[] args) throws Exception {
        GGCTuition tuition = new GGCTuition();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Georgia Gwinnett College Tuition Calculator");
        System.out.println();
        System.out.println("Select the following options below:");
        System.out.println("1: View instate tuition: ");
        System.out.println("2: View out of state tuition ");

        String userInput = input.nextLine();

        if(userInput.equalsIgnoreCase("1"))
            tuition.GGCInstateTuition();
        else if(userInput.equalsIgnoreCase("2"))
            tuition.GGCOutOfStateTuition();
        else
            System.out.println("Error");
    }
}

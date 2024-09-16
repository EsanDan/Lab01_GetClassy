import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class SafeInput {
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (console.hasNextInt()) {
                retVal = console.nextInt();
                console.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = console.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    public static double getRangedDouble(Scanner console, String prompt, int low, int high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (console.hasNextDouble()) {
                retVal = console.nextDouble();
                console.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = console.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    public static String getString(Scanner console, String prompt) {
        String retval = "";
        System.out.println("\n" + prompt + ": ");
        if (console.hasNext()) {
            retval = console.nextLine();
        }
        return retval;
    }

    public static ArrayList<String> getArrayOfStrings(Scanner console, String prompt) {
        Boolean doneEntering = false;
        ArrayList<String> retval = new ArrayList<>();
        System.out.println("\n" + prompt + ": ");
        do {
            if (console.hasNext()) {
                retval.add(console.nextLine());
            }
            doneEntering = !getYNConfirm(console, "Add more? ");
        } while (!doneEntering);
        return retval;
    }

    public static int getRangedIntDialog(String prompt, int low, int high) {
        int retVal = 0;
        String inputString = "";
        boolean done = false;

        do {
            inputString = JOptionPane.showInputDialog(null, prompt + " [" + low + "-" + high + "]: ");

            try {
                retVal = Integer.parseInt(inputString);

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Number is out of range [" + low + "-" + high + "]: " + inputString);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You must enter a number [" + low + "-" + high + "]: " + inputString);

            }
        } while (!done);

        return retVal;
    }

    public static double getRangedDoubleDialog(String prompt, int low, int high) {
        double retVal = 0;
        String inputString = "";
        boolean done = false;

        do {
            inputString = JOptionPane.showInputDialog(null, prompt + " [" + low + "-" + high + "]: ");

            try {
                retVal = Double.parseDouble(inputString);

                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Number is out of range [" + low + "-" + high + "]: " + inputString);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "You must enter a number [" + low + "-" + high + "]: " + inputString);

            }
        } while (!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = console.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must answere [Y/N]! " + response);
            }

        } while (!gotAVal);

        return retVal;
    }

    public static boolean getYNConfirmDialog(String prompt) {
        boolean retVal = true;

        int dialogResponse = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (dialogResponse == JOptionPane.NO_OPTION) {
            retVal = false;
        } else if (dialogResponse == JOptionPane.YES_OPTION) {
            retVal = true;
        } else if (dialogResponse == JOptionPane.CLOSED_OPTION) {
            retVal = false;
        }

        return retVal;
    }

    public static String getEmail(Scanner console, String prompt) {
        String retval = "";
        boolean done = false;
        do {
            System.out.println("\n" + prompt);
            if (console.hasNext()) {
                retval = console.next();
            }

            String regex = "^(.+)@(.+)$";

            Pattern pattern = Pattern.compile(regex);

            if (pattern.matcher(retval).matches()) {
                done = true;
            } else {
                System.out.println("Your input doesn't match an Email pattern");
            }

        } while (!done);

        return retval;
    }
}
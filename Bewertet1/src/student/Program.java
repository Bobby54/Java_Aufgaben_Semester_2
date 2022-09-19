package student;

import java.util.Locale;

public class Program
{
    public static void main(String args[])
    {
        if (args.length < 2) {
            System.out.println("Ungenügende Anzahl Parameter");
        } else {
            String op = args[0];
            int[] array = new int[args.length - 1];

            for (int i = 1; i <= array.length; i++) {
                array[i - 1] = Integer.parseInt(args[i]);
            }

            if (op.equals("min")) {
                System.out.println("Minimum: " + Statistics.min(array));
            } else if (op.equals("max")) {
                System.out.println("Maximum: " + Statistics.max(array));
            } else if (op.equals("mw")) {
                System.out.printf(Locale.US, "Mittelwert: %.2f", Statistics.mean(array));
            } else if (op.equals("saw")) {
                System.out.printf(Locale.US, "Standardabweichung: %.4f", +Statistics.stddev(array));
            } else {
                System.out.println("Unbekannte Operation");
            }

        }
    }
}

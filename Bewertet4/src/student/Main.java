package student;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        double value;
        String symbol;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Eingabe einer Höhe (<Wert> <Einheit>):");
        String input = scanner.nextLine();
        String[] split = input.split("\\s+");
        if(split.length < 2)
        {
            value = Double.parseDouble(split[0]);
            symbol = "m";
        } else {
            value = Double.parseDouble(split[0]);
            symbol = split[1];
        }

        Length len = new Length(LengthUnit.fromSymbol(symbol), value);

        if (len.compareTo(AtmosphericLayer.TROPO.getStartAltitude()) >= 0) {
            if (len.compareTo(AtmosphericLayer.STRATO.getStartAltitude()) >= 0) {
                if (len.compareTo(AtmosphericLayer.MESO.getStartAltitude()) >= 0) {
                    if (len.compareTo(AtmosphericLayer.THERMO.getStartAltitude()) >= 0) {
                        if (len.compareTo(AtmosphericLayer.EXO.getStartAltitude()) >= 0) {
                            System.out.println("Mit einer Höhe von " + len.toString() + " befinden Sie sich in der " + AtmosphericLayer.EXO.getGerman());
                        } else {
                            System.out.println("Mit einer Höhe von " + len.toString() + " befinden Sie sich in der " + AtmosphericLayer.THERMO.getGerman());
                        }
                    } else {
                        System.out.println("Mit einer Höhe von " + len.toString() + " befinden Sie sich in der " + AtmosphericLayer.MESO.getGerman());
                    }
                } else {
                    System.out.println("Mit einer Höhe von " + len.toString() + " befinden Sie sich in der " + AtmosphericLayer.STRATO.getGerman());
                }
            } else {
                System.out.println("Mit einer Höhe von " + len.toString() + " befinden Sie sich in der " + AtmosphericLayer.TROPO.getGerman());
            }
        }
    }
}

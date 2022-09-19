package student;

public class Main {
    //Signatur der Methode darf nicht verändert werden!
    public static void addObserverForIntegerList(MinMidMax<Integer> mmm)
    {
        //Fügen Sie hier einen Beobachter mit geeigneter Implementation (siehe Aufgabenstellung) zum Objekt mmm hinzu
        Observer observer = new Observer(mmm);

    }

    //Signatur der Methode darf nicht verändert werden!
    public static void addObserverForStringList(MinMidMax<String> mmm)
    {
        //Fügen Sie hier einen Beobachter mit geeigneter Implementation (siehe Aufgabenstellung) zum Objekt mmm hinzu
        Observer observer = new Observer(mmm);
    }

    //Führen Sie das Programm aus, um Ihre Implementation zu testen und das Ergebnis mit den in der Aufgabenstellung
    //dargestellten Ausgaben zu vergleichen
    public static void main(String[] args)
    {
        testWithInteger();

        System.out.println();
        testWithString();
    }

    //Methode nicht verändern!
    public static void testWithInteger()
    {
        MinMidMax<Integer> mmm = new MinMidMax<>(3, 9, 1);
        addObserverForIntegerList(mmm);
        System.out.printf("Liste: %s\n", mmm);
        mmm.push(0);
        mmm.push(5);
        mmm.push(4);
        mmm.push(11);
        mmm.push(10);
        mmm.push(101);
        mmm.push(-15);
        mmm.push(-1);
        mmm.push(-1); //Wert schon vorhanden
        mmm.popRight();
        mmm.popLeft();
        mmm.popLeft();
        System.out.printf("Minimum: %d\n", mmm.getMinimum());
        System.out.printf("Maximum: %d\n", mmm.getMaximum());
        System.out.printf("Median: %d\n", mmm.getMid());
    }

    //Methode nicht verändern!
    public static void testWithString()
    {
        MinMidMax<String> mmm = new MinMidMax<>("bh", "ah", "fa", "ch", "bh"); //Element bh doppelt
        addObserverForStringList(mmm);
        System.out.printf("Liste: %s\n", mmm);
        mmm.push("ae");
        mmm.push("bb");
        mmm.push("ba");
        mmm.push("ck");
        mmm.push("cj");
        mmm.push("qa");
        mmm.push("aa");
        mmm.push("ac");
        mmm.push("ac"); //Element schon vorhanden
        mmm.popRight();
        mmm.popLeft();
        mmm.popLeft();
        mmm.popRight();
        mmm.popRight();
        System.out.printf("Minimum: %s\n", mmm.getMinimum());
        System.out.printf("Maximum: %s\n", mmm.getMaximum());
        System.out.printf("Median: %s\n", mmm.getMid());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popLeft: %s\n", mmm.popLeft());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight());
        System.out.printf("Rückgabe popRight: %s\n", mmm.popRight()); //Element existiert nicht
    }

    public static class Observer implements  ListObserver{
        public Observer(MinMidMax minMidMax){
            minMidMax.addObserver(this);
        }
        public void  pushedToList(Object add, Object element ){
            System.out.println("Zur Liste hinzugefügt: " + element + " -> neue Liste mit " + ((MinMidMax) add).getNumItems() + " Elementen: " + ((MinMidMax) add).toString());
        }
        public void  poppedFromList(Object delete, Object element){
            System.out.println("Von Liste entfernt: " + element + " -> neue Liste mit " + ((MinMidMax) delete).getNumItems() + " Elementen: " + ((MinMidMax) delete).toString());
        }
    }
}


package student;

public enum LengthUnit {

    METER("m", 1),
    INCH("\"", 0.0254),
    FEET("ft", 0.3048),
    NAUTICAL_MILE("NM", 1852);

    private String symbol;
    private double linm;
    LengthUnit(String symbol, double linm) {
        this.symbol = symbol;
        this.linm = linm;
    }

    public String getSymbol(){
        return symbol;
    }

    public double getInMeters(){
        return linm;
    }

    @Override
    public String toString(){
        return symbol;
    }

    public static LengthUnit fromSymbol(String symbol){
        if(symbol != null) {
            return switch (symbol) {
                case "m" -> METER;
                case "\"" -> INCH;
                case "ft" -> FEET;
                case "NM" -> NAUTICAL_MILE;
                default -> null;
            };
        }else{
            return null;
        }
    }
}

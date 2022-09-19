package student;

public class Length implements Comparable<Length> {
    public double value;
    public LengthUnit unit;

    public Length(){
        value = 0;
        unit = LengthUnit.METER;
    }
    public Length(double value){
        this.value = value;
        unit = LengthUnit.METER;
    }
    public Length(LengthUnit unit, double value){
        if(unit != null) {
            this.unit = unit;
        }else{
            throw new IllegalArgumentException("Leere Referenz");
        }
        this.value = value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }

    public void setUnit(LengthUnit unit){
        if(unit == null){
            throw new IllegalArgumentException("Leere Referenz");
        }else{
            this.unit = unit;
        }
    }

    public LengthUnit getUnit(){
        return unit;
    }

    @Override
    public String toString() {
        return String.format("%.4f %s", value, unit);
    }

    public double getValueIn(LengthUnit otherunit){
        if(otherunit == null){
            throw new IllegalArgumentException("Leere Referenz");
        }else{
            return value*this.unit.getInMeters()/otherunit.getInMeters();
        }
    }


    @Override
    public int compareTo(Length o) {
        if(o == null){
            throw new IllegalArgumentException("Leere Referenz");
        }else{
            if(value*this.unit.getInMeters() > o.value*o.unit.getInMeters()){
                return 1;
            }else if(value*this.unit.getInMeters() < o.value*o.unit.getInMeters()){
                return -1;
            }else{
                return 0;
            }
        }
    }

    @Override
    public boolean equals(Object length2){
        if(length2 instanceof Length){
            return this.compareTo((Length) length2) == 0;
        }else{
            return false;
        }
    }
}
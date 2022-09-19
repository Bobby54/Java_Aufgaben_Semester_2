package student;

public class Figure {
    private boolean black;

    public Figure(){}
    public Figure(boolean black){
        this.black = black;
    }

    public boolean canMoveTo(Position pos1, Position pos2){
        if(pos1 != null && pos2 != null){
            if (pos1.equals(pos2)) {
                return false;
            } else {
                return true;
            }
        }else{
            throw new IllegalArgumentException("Leere Referenz!");
        }
    }

    public char getSymbol(){
        return '?';
    }

    public String getLabel(){
        return "Unbekannte Figur";
    }

    public Figure getFigur(){
        return this;
    }

    public boolean getBlack(){
        return black;
    }

    @Override
    public String toString(){
        if(black) {
            return getLabel() + " (schwarz)";
        }else{
            return getLabel() + " (weiß)";
        }
    }

}

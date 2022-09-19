package student;

public class King extends Figure{

    public King(boolean black) {
        super(black);
    }
    public boolean canMoveTo(Position pos1, Position pos2){
        if(pos1 == null || pos2 == null) {throw new IllegalArgumentException();}
        int i = Math.abs(pos1.getRow() - pos2.getRow());
        int j = Math.abs(pos1.getColumn() - pos2.getColumn());
        if(i <= 1 && j <= 1){return true;}else{return false;}
    }
    public char getSymbol() {
        if(getBlack()) {
            return '♚';
        } else {return '♔';}
    }
    public String getLabel() {
        return "König";
    }
}
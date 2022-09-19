package student;

public class Queen extends Figure{
    public Queen(boolean b) {
        super(b);
    }
    public boolean canMoveTo(Position pos1, Position pos2){
        if (pos1 == null || pos2 == null){throw new IllegalArgumentException();}
        int i = Math.abs(pos1.getRow() - pos2.getRow());
        int j = Math.abs(pos1.getColumn() - pos2.getColumn());
        if(i == j && i != 0){return true;}
        else if(pos1.getRow() == pos2.getRow() && pos1.getColumn() != pos2.getColumn()){return true;}
        else if(pos1.getRow() != pos2.getRow() && pos1.getColumn() == pos2.getColumn()){return true;}
        else{return false;}
    }
    public char getSymbol() {
        if(getBlack()) {
            return '♛';
        } else {return '♕';}
    }
    public String getLabel() {
        return "Dame";
    }
}
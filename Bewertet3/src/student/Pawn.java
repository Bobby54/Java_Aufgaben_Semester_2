package student;

public class Pawn extends Figure{
    public Pawn(boolean b) {
        super(b);
    }
    public boolean canMoveTo(Position pos1, Position pos2){
        if (pos1 == null || pos2 == null){throw new IllegalArgumentException();}
        else if(getBlack() && pos1.getColumn() == pos2.getColumn()){
            if(pos1.getRow() == pos2.getRow()+1){return true;}
            else if(pos1.getRow() == 6 && pos1.getRow() == pos2.getRow()+2){return true;}
            else{return false;}
        }
        else if(!getBlack() && pos1.getColumn() == pos2.getColumn()){
            if(pos1.getRow() == pos2.getRow()-1){return true;}
            else if(pos1.getRow() == 1 && pos1.getRow() == pos2.getRow()-2){return true;}
            else{return false;}
        }
        else{return false;}
    }
    public char getSymbol() {
        if(getBlack()) {
            return '♟';
        } else {return '♙';}
    }
    public String getLabel() {
        return "Bauer";
    }
}
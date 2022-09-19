package student;

public class Knight extends Figure{

    public Knight(boolean b) {
        super(b);
    }
    public boolean canMoveTo(Position pos1, Position pos2){
        if(pos1 == null || pos2 == null) {
            throw new IllegalArgumentException();
        }else if(Math.abs(pos1.getRow() - pos2.getRow()) == 2){
            if(Math.abs(pos1.getColumn()- pos2.getColumn()) == 1){
                return true;
            }else{return false;}
        }else if(Math.abs(pos1.getColumn()- pos2.getColumn()) == 2){
            if(Math.abs(pos1.getRow() - pos2.getRow()) == 1){
                return true;
            }else{return false;}
        }

        return false;
    }
    public char getSymbol() {
        if(getBlack()) {
            return '♞';
        } else {return '♘';}
    }
    public String getLabel() {
        return "Springer";
    }
}
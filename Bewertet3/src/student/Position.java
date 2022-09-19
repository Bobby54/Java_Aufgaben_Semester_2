package student;

public class Position {
    private int row, column;

    public Position(int column, int row) {
        if (row < 0 || row > 7 || column < 0 || column > 7) {
            throw new IllegalArgumentException("Ungültige Spalte bzw Zeile!");
        } else {
            this.column = column;
            this.row = row;
        }
    }

    public Position(String pos) {

        if(pos != null && pos.length() == 2){

            char letter = (char) pos.charAt(0);
            switch (letter) {
                case 'a':
                    column = 0;
                    break;
                case 'b':
                    column = 1;
                    break;
                case 'c':
                    column = 2;
                    break;
                case 'd':
                    column = 3;
                    break;
                case 'e':
                    column = 4;
                    break;
                case 'f':
                    column = 5;
                    break;
                case 'g':
                    column = 6;
                    break;
                case 'h':
                    column = 7;
                    break;
                default:
                    throw new IllegalArgumentException("Unzulässige Spalteneingabe!");
            }
            int nrow = pos.charAt(1) - '0' - 1;
            if(nrow < 0 || nrow > 7){
                throw new IllegalArgumentException("Unzulässige Zeileneingabe!");
            }else{
                row = nrow;
            }

        }else{
            throw new IllegalArgumentException("Leere oder Falsche Eingabe!");
        }
    }

    public int getColumn(){
        return column;
    }

    public int getRow(){
        return row;
    }

    @Override
    public String toString(){
        char c = (char) ('a' + column);
        return "" + c + (row + 1);
    }

    @Override
    public boolean equals(Object pos2){
        if(pos2 instanceof Position && pos2 != null) {
            Position position2 = (Position) pos2;
            if (position2.column == this.column && position2.row == this.row) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
}

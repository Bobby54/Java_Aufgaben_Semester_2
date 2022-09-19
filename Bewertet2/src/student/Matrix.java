package student;

public class Matrix {

    private String label;
    private int rows, columns;
    private double values[][];

    Matrix(){
        rows = 3;
        columns = 3;
        values = new double[rows][columns];
        label = "E";
    }
    Matrix(String label, int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.label = label;
        values = new double[rows][columns];
    }

    public double[][] getValues(){
        return values;
    }

    public String getLabel(){
        return label;
    }

    void setLabel(String label){
        this.label = label;
    }

    int getRows(){
        return rows;
    }

    int getColumns(){
        return columns;
    }

    double getValues(int row, int column){
        return values[row][column];
    }

    void setValue(int row, int column, double value) {
        if (row >= rows || column >= columns) {
            throw new IllegalArgumentException("Ungültige Spalte oder Zeile!");
        } else {
            values[row][column] = value;
        }
    }

    void setIdentity(){
        if(rows == columns){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    values[i][j] = 0;
                }
            }
            for(int i = 0; i < rows; i++){
                values[i][i] = 1;
            }
        }
    }

    Matrix mul(double a){
        Matrix m = new Matrix("Result", getRows(), getColumns());
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                m.values[i][j] = a * values[i][j];
            }
        }
        return m;
    }

}

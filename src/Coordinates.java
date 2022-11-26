public class Coordinates {
    private int columnCoordinate;
    private int rowCoordinate;

    public Coordinates(int rowCoordinate, int columnCoordinate) {
        this.setRowCoordinate(rowCoordinate);
        this.setColumnCoordinate(columnCoordinate);
    }

    // Deep copy constructor;
    public Coordinates(Coordinates deepCopy) {
        this(deepCopy.getRowCoordinate(), deepCopy.getColumnCoordinate());
    }

    public int[] getCoordinates() {
        return new int[]{this.getRowCoordinate(), this.getColumnCoordinate()};
    }

    public int getColumnCoordinate() {
        return this.columnCoordinate;
    }

    public void setColumnCoordinate(int columnCoordinate) {
        this.columnCoordinate = columnCoordinate;
    }

    public int getRowCoordinate() {
        return rowCoordinate;
    }

    public void setRowCoordinate(int rowCoordinate) {
        this.rowCoordinate = rowCoordinate;
    }
}

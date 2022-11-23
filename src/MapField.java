public class MapField {
    protected char fieldSymbol;
    protected boolean isEatable;
    protected boolean isPassable;

    protected Coordinates fieldCoordinates;

    public MapField() {
        this.fieldSymbol = 'W';
        this.isEatable = false;
        this.isPassable = false;
    }

    public MapField(char fieldSymbol, boolean isEatable, boolean isPassable) {
        this.fieldSymbol = fieldSymbol;
        this.isEatable = isEatable;
        this.isPassable = isPassable;
    }

    public void printSymbol() {
        System.out.print(this.getFieldSymbol());
    }

    public char getFieldSymbol() {
        return fieldSymbol;
    }

    public void setFieldSymbol(char fieldSymbol) {
        this.fieldSymbol = fieldSymbol;
    }

    public boolean isEatable() {
        return isEatable;
    }

    public void setEatable(boolean eatable) {
        isEatable = eatable;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public void setPassable(boolean passable) {
        isPassable = passable;
    }
}

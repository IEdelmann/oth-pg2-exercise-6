public abstract class MapField {
    protected char fieldSymbol;
    protected boolean consumable;
    protected boolean passable;

    protected Coordinates fieldCoordinates;

    public void printSymbol() {
        System.out.print(this.getFieldSymbol());
    }

    public char getFieldSymbol() {
        return this.fieldSymbol;
    }

    public void setFieldSymbol(char fieldSymbol) {
        this.fieldSymbol = fieldSymbol;
    }

    public boolean isConsumable() {
        return this.consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    public boolean isPassable() {
        return this.passable;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    public Coordinates getFieldCoordinates() {
        return this.fieldCoordinates;
    }

    public void setFieldCoordinates(Coordinates fieldCoordinates) {
        this.fieldCoordinates = fieldCoordinates;
    }
}






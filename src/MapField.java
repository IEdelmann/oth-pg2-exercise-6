public abstract class MapField {
    protected char fieldSymbol;
    protected boolean consumable;
    protected boolean passable;

    protected Coordinates fieldCoordinates;

//    public MapField(int xCoordinate, int yCoordinate) {
//        this.fieldCoordinates = new Coordinates(xCoordinate, yCoordinate);
//    }

    public void printSymbol() {
        System.out.print(this.getFieldSymbol());
    }

    public char getFieldSymbol() {
        return fieldSymbol;
    }

    public void setFieldSymbol(char fieldSymbol) {
        this.fieldSymbol = fieldSymbol;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    public boolean isPassable() {
        return passable;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    public Coordinates getFieldCoordinates() {
        return fieldCoordinates;
    }

    public void setFieldCoordinates(Coordinates fieldCoordinates) {
        this.fieldCoordinates = fieldCoordinates;
    }
}






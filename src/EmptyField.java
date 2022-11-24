public class EmptyField extends MapField {
    public EmptyField() {
        this.fieldSymbol = ' ';
        this.consumable = false;
        this.passable = true;
    }

    public EmptyField(int xCoordinate, int yCoordinate) {
        this.fieldSymbol = ' ';
        this.consumable = false;
        this.passable = true;
        this.fieldCoordinates = new Coordinates(xCoordinate, yCoordinate);
    }
}

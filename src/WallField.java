public class WallField extends MapField {

    public WallField() {
        this.passable = false;
        this.consumable = false;
        this.fieldSymbol = '#';
    }

    public WallField(int xCoordinate, int yCoordinate) {
        this.passable = false;
        this.consumable = false;
        this.fieldSymbol = '#';
        this.fieldCoordinates = new Coordinates(xCoordinate, yCoordinate);
    }
}

public class CornField extends MapField {

    CornField() {
        this.fieldSymbol = '*';
        this.consumable = true;
        this.passable = false;
    }

    CornField(int xCoordinate, int yCoordinate) {
        this.fieldSymbol = '*';
        this.consumable = true;
        this.passable = false;
        this.fieldCoordinates = new Coordinates(xCoordinate, yCoordinate);
    }
}

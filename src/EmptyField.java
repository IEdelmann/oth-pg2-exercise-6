public class EmptyField extends MapField {
    // Set to private - only for testing purposes;
    private EmptyField() {
        this.setFieldSymbol(' ');
        this.setConsumable(false);
        this.setPassable(true);
    }

    public EmptyField(int rowCoordinate, int columnCoordinate) {
        this.setFieldSymbol(' ');
        this.setConsumable(false);
        this.setPassable(true);
        this.setFieldCoordinates(new Coordinates(rowCoordinate, columnCoordinate));
    }

    // Constructor to create the EmptyField object with a Coordinate object instead of int coordinates;
    public EmptyField(Coordinates newCoordinates) {
        this.setFieldSymbol(' ');
        this.setConsumable(false);
        this.setPassable(true);
        this.setFieldCoordinates(new Coordinates(newCoordinates));
    }
}

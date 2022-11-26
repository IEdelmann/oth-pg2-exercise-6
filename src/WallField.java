public class WallField extends MapField {
    // Set to private - only for testing purposes;
    public WallField() {
        this.setFieldSymbol('#');
        this.setConsumable(false);
        this.setPassable(false);
    }

    public WallField(int rowCoordinate, int columnCoordinate) {
        this.setFieldSymbol('#');
        this.setConsumable(false);
        this.setPassable(false);
        this.setFieldCoordinates(new Coordinates(rowCoordinate, columnCoordinate));
    }
}

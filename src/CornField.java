public class CornField extends MapField {
    // Set to private - only for testing purposes;
    public static int cornSpawn;
    private CornField() {
        this.setFieldSymbol('*');
        this.setConsumable(true);
        this.setPassable(true);
    }

    public CornField(int rowCoordinate, int columnCoordinate) {
        this.setFieldSymbol('*');
        this.setConsumable(true);
        this.setPassable(true);
        this.setFieldCoordinates(new Coordinates(rowCoordinate, columnCoordinate));
    }
}

public class Hamster {
    private int direction;
    private int cornEaten;
    private Coordinates currentCoordinates;

    public Hamster() {
        this.direction = 0;
        this.cornEaten = 0;
    }

    public boolean moveForward(MapField mapField) {
        return true;
    }

    public Coordinates getCurrentCoordinates() {
        return currentCoordinates;
    }

    public void setCurrentCoordinates(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getCornEaten() {
        return cornEaten;
    }

    public void setCornEaten(int cornEaten) {
        this.cornEaten = cornEaten;
    }
}

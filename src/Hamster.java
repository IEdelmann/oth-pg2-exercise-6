public class Hamster extends MapField {
    private int direction;
    private int cornEaten;

    // Set to private - only for testing purposes;
    private Hamster() {
        this.setDirection(0);
        this.setCornEaten(0);
        this.setFieldSymbol('^');
        this.setConsumable(false);
        this.setPassable(false);
    }

    public Hamster(int rowCoordinate, int columnCoordinate) {
        this.setDirection(0);
        this.setCornEaten(0);
        this.setFieldSymbol('^');
        this.setConsumable(false);
        this.setPassable(false);
        this.setFieldCoordinates(new Coordinates(rowCoordinate, columnCoordinate));
    }

    public void consumeCorn() {
        this.setCornEaten(this.getCornEaten() + 1);
    }

    public void changeDirection(int directionInstruction) {
        this.setDirection(directionInstruction);
        changeDirectionOfSymbol();
    }

    private void changeDirectionOfSymbol() {
        switch (this.getDirection()) {

            case 0 -> {
                this.setFieldSymbol('^');
            }

            case 1 -> {
                this.setFieldSymbol('>');
            }

            case 2 -> {
                this.setFieldSymbol('v');
            }

            case 3 -> {
                this.setFieldSymbol('<');
            }

            default -> {
                System.out.println("If you see this line, you somehow broke the code!");
            }
        }
    }

    public Coordinates getCoordinatesOfFieldInFront() {
        int[] coordinatesOfFieldInFront = this.getFieldCoordinates().getCoordinates();

        switch (this.getDirection()) {

            case 0 -> {
               coordinatesOfFieldInFront[0] -= 1;
            }

            case 1 -> {
                coordinatesOfFieldInFront[1] += 1;
            }

            case 2 -> {
                coordinatesOfFieldInFront[0] += 1;
            }

            case 3 -> {
                coordinatesOfFieldInFront[1] -= 1;
            }

            default -> {
                System.out.println("If you see this line, somethings wrong the hamsters direction variable!");
            }
        }

        return new Coordinates(coordinatesOfFieldInFront[0], coordinatesOfFieldInFront[1]);
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getCornEaten() {
        return this.cornEaten;
    }

    public void setCornEaten(int cornEaten) {
        this.cornEaten = cornEaten;
    }
}

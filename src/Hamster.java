public class Hamster extends MapField {
    private int direction;
    private int cornEaten;

    public Hamster() {
        this.direction = 0;
        this.cornEaten = 0;
        this.fieldSymbol = '^';
        this.consumable = false;
        this.passable = false;
    }

    public Hamster(int xCoordinate, int yCoordinate) {
        this.direction = 0;
        this.cornEaten = 0;
        this.fieldSymbol = '^';
        this.consumable = false;
        this.passable = false;
        this.fieldCoordinates= new Coordinates(xCoordinate, yCoordinate);
    }

    public void changeDirection(int directionInstruction) {
        if (directionInstruction >= -1 && directionInstruction <= 1) {
            directionConverter(directionInstruction);
            changeDirectionOfSymbol();
        }
    }

    private void directionConverter(int directionChange) {
        int temp = this.getDirection() + directionChange;

        if (temp > 3) {
            this.setDirection(0);
        }

        if (temp < 0) {
            this.setDirection(3);
        }
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

    private Coordinates getCoordinatesOfFieldInFront() {
        int[] coordinatesOfFieldInFront = this.getFieldCoordinates().getCoordinate();

        switch (this.direction) {

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

//    private MapField fieldInFront(Coordinates coordinatesOfField) {
//
//    }

    private boolean interactWithFieldInFront(Coordinates coordinatesOfFieldInFront) {
        return true;
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

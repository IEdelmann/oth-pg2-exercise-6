public class Hamster extends MapField {
    private int direction;
    private int cornEaten;
    private Coordinates currentCoordinates;

    public Hamster() {
        this.direction = 0;
        this.cornEaten = 0;
        this.fieldSymbol = '^';
        this.consumable = false;
        this.passable = false;
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

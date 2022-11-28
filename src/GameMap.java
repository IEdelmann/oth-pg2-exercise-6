import java.util.ArrayList;
import java.util.Random;

public class GameMap {
    private final int columnDimension;
    private final int rowDimension;
    private final double chanceWallField;
    private final double chanceEmptyField;
    private final double chanceCornField;
    private ArrayList<ArrayList<MapField>> finalGameMap;
    private Hamster gameHamster;

    // When creating a 'GameMap' object, the dimensions have to be set but the default chances for various field types are applied;
    public GameMap(int columnDimension, int rowDimension) {
        this.columnDimension = columnDimension;
        this.rowDimension = rowDimension;

        // WallField = 40%, EmptyField = 50%, CornField = 10%;
        // '-1' because the chance is calculated for i.e. 10 fields, but it's actually only 9;
        this.chanceWallField = chanceConverter(rowDimension, 40) - 1;
        this.chanceEmptyField = chanceConverter(rowDimension, 50) - 1;
        this.chanceCornField = chanceConverter(rowDimension, 10) - 1;
        this.finalGameMap = generateMap(this.rowDimension, this.columnDimension);
    }

    // Constructor for generating the game map with customized field type chances;
    public GameMap(int rowDimension, int columnDimension, int chanceWallField, int chanceCornField, int chanceEmptyField) {
        this.rowDimension = rowDimension;
        this.columnDimension = columnDimension;

        // '-1' because the chance is calculated for i.e. 10 fields, but it's actually only 9;
        this.chanceWallField = chanceConverter(this.columnDimension, chanceWallField) - 1;
        this.chanceCornField = chanceConverter(this.columnDimension, chanceCornField) - 1;
        this.chanceEmptyField = chanceConverter(this.columnDimension, chanceEmptyField) - 1;
        this.finalGameMap = generateMap(this.rowDimension, this.columnDimension);
    }

    private void spawnHamster(ArrayList<ArrayList<MapField>> generatedMap) {
        int spawnRowCoordinate = this.getRowDimension() - 2;
        int spawnColumnCoordinate = 1;      // The hamster object is always spawned at the same location at the bottom on the left side;

        setGameHamster(new Hamster(spawnRowCoordinate, spawnColumnCoordinate));

        generatedMap.get(spawnRowCoordinate).remove(1);
        generatedMap.get(spawnRowCoordinate).add(1, gameHamster);
    }

    private void replaceField(MapField toBeReplaced, MapField replaceWith) {
        int[] coordinatesOfFieldToBeReplaced = toBeReplaced.getFieldCoordinates().getCoordinates();

        finalGameMap.get(coordinatesOfFieldToBeReplaced[0]).remove(coordinatesOfFieldToBeReplaced[1]);
        finalGameMap.get(coordinatesOfFieldToBeReplaced[0]).add(coordinatesOfFieldToBeReplaced[1], replaceWith);
    }

    public void moveHamster(char inputInstruction) {
        int currentDirection = this.gameHamster.getDirection();
        MapField fieldInFrontOfHamster = getFieldInFrontOfHamster();

        switch (inputInstruction) {

            case 'w' -> {
                if (currentDirection != 0) {
                    gameHamster.changeDirection(0);
                    return;
                }

                if(interactWithFieldInFrontOfHamster(fieldInFrontOfHamster)) {
                    System.out.println("Cannot move forward!");
                }
            }

            case 'a' -> {
                if (currentDirection != 3) {
                    gameHamster.changeDirection(3);
                    return;
                }

                if(interactWithFieldInFrontOfHamster(fieldInFrontOfHamster)) {
                    System.out.println("Cannot move forward!");
                }
            }

            case 's' -> {
                if (currentDirection != 2) {
                    gameHamster.changeDirection(2);
                    return;
                }

                if(interactWithFieldInFrontOfHamster(fieldInFrontOfHamster)) {
                    System.out.println("Cannot move forward!");
                }
            }

            case 'd' -> {
                if (currentDirection != 1) {
                    gameHamster.changeDirection(1);
                    return;
                }

                if(interactWithFieldInFrontOfHamster(fieldInFrontOfHamster)) {
                    System.out.println("Cannot move forward!");
                }
            }
        }
    }

    private boolean interactWithFieldInFrontOfHamster(MapField mapField) {

        if (mapField.isConsumable()) {
            this.getGameHamster().consumeCorn();
            replaceField(mapField, new EmptyField(new Coordinates(mapField.getFieldCoordinates())));
            printHamsterNoises();
            return false;
        }

        if (mapField.isPassable()) {
            Coordinates oldHamsterCoordinates = new Coordinates(gameHamster.getFieldCoordinates());

            replaceField(gameHamster, new EmptyField(oldHamsterCoordinates));
            gameHamster.setFieldCoordinates(new Coordinates(mapField.getFieldCoordinates()));
            replaceField(mapField, gameHamster);
            return false;
        }

        return true;
    }

    private void printHamsterNoises() {
        int randomHamsterNoise = randomChance(6);

        switch (randomHamsterNoise) {
            case 0 -> {
                System.out.println("Hummhh... yeah! Now that is some delicious corn...");
            }
            case 1 -> {
                System.out.println("Damn! That juicy... corn...");
            }
            case 2 -> {
                System.out.println("Those are some well-shaped... corns...");
            }
            case 3 -> {
                System.out.println("Big...corns!");
            }
            case 4 -> {
                System.out.println("Corns... I need more corns...!");
            }
            case 5 -> {
                System.out.println("Those corns are *definitely* real... gulp...!");
            }
        }
    }

    private MapField getFieldInFrontOfHamster() {
        int[] coordinatesOfFieldInFrontOfHamster = this.gameHamster.getCoordinatesOfFieldInFront().getCoordinates();

        return this.finalGameMap.get(coordinatesOfFieldInFrontOfHamster[0]).get(coordinatesOfFieldInFrontOfHamster[1]);
    }

    // Simply breaks down the field type chances down to the actually available amount of fields;
    private double chanceConverter(int columnDimension, int chance) {
        return ((double)columnDimension * chance) / 100;
    }

    // Returns a random value between 0 and the given parameter - 1;
    private int randomChance(int maxValue) {
        Random random = new Random();

        return random.nextInt(maxValue);
    }

    // Goes through the game map ArrayLists and instructs every field object to print its symbol;
    public void printGameMap() {
        for (int row = 0; row < this.getRowDimension(); row++) {

            for (int column = 0; column < this.getColumnDimension(); column++) {

                this.finalGameMap.get(row).get(column).printSymbol();
            }
            System.out.println();
        }
    }

    // Only for testing purposes, print the field objects x/y coordinates;
    public void printGameMapCoordinates() {
        for (int row = 0; row < this.getRowDimension(); row++) {

            for (int column = 0; column < this.getColumnDimension(); column++) {
                int[] temp = this.getFinalGameMap().get(row).get(column).getFieldCoordinates().getCoordinates();
                System.out.print("(" + temp[0] + "/" + temp[1] + ") ");
            }
            System.out.println();
        }
    }

    // Generates the whole game map;
    private ArrayList<ArrayList<MapField>> generateMap(int rowDimension, int columnDimension) {
        ArrayList<ArrayList<MapField>> generatedMap = new ArrayList<>();

        generatedMap.add(generateWallTypeRow(0, columnDimension));       // The first row is always filled with WallType objects;

        for (int row = 1; row < rowDimension - 2; row++) {
            generatedMap.add(generateRandomRow(row, columnDimension));
        }

        // Generate a row filled with EmptyField objects to safely spawn the hamster object;
        generatedMap.add(generateEmptyTypeRow(rowDimension - 2, columnDimension));

        generatedMap.add(generateWallTypeRow(rowDimension - 1, columnDimension)); // The last row is always filled with WallType objects;

        // Spawn the hamster object into the game map;
        spawnHamster(generatedMap);

        return generatedMap;
    }

    private ArrayList<MapField> generateRandomRow(int row, int columnDimension) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        generatedArray.add(new WallField(row, 0)); // The first object of every columnDimension is a WallType object;

        int randomFieldType;

        // Splits the changes of the various field types into a 'range';
        double wallTypeLine = this.getChanceWallField();
        double emptyTypeLine = wallTypeLine + this.getChanceEmptyField();
        double cornTypeLine = columnDimension - 2; // The given columnDimension-dimension is always *1* larger than is actually possible - 10 yields a range from 0 to 9;

        // Fills the ArrayList with random field type objects;
        for (int i = 1; i < columnDimension - 1; i++) {   // columnDimension - 1 because there has to be room for the last field as it is supposed to be a WallField object;
            randomFieldType = randomChance(columnDimension - 1); // '-1' because... see the comment above;

            if (randomFieldType <= wallTypeLine) {
                generatedArray.add(new WallField(row, i));
                continue;
            }

            if (randomFieldType <= emptyTypeLine) {
                generatedArray.add(new EmptyField(row, i));
                continue;
            }

            if (randomFieldType <= cornTypeLine) {
                generatedArray.add(new CornField(row, i));
            }
        }

        // The last field type object in every array is a WallType object;
        generatedArray.add(new WallField(row, columnDimension - 1));

        return generatedArray;
    }

    // Return a ArrayList completely filled with WallType objects;
    private ArrayList<MapField> generateWallTypeRow(int rowPosition, int columnDimension) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        for (int i = 0; i < columnDimension; i++) {
            generatedArray.add(new WallField(rowPosition, i));
        }

        return generatedArray;
    }

    // Return a ArrayList completely filled with EmptyType objects;
    private ArrayList<MapField> generateEmptyTypeRow(int rowPosition, int columnDimension) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        generatedArray.add(new WallField(rowPosition, 0));

        // columnDimension - 1 because the last field type has to be WallType object;
        for (int i = 1; i < columnDimension - 1; i++) {
            generatedArray.add(new EmptyField(rowPosition, i));
        }

        // The last field type is a WallType object;
        generatedArray.add(new WallField(rowPosition, columnDimension - 1));

        return generatedArray;
    }

    public Hamster getGameHamster() {
        return gameHamster;
    }

    public int getColumnDimension() {
        return columnDimension;
    }

    public int getRowDimension() {
        return rowDimension;
    }

    public double getChanceWallField() {
        return chanceWallField;
    }

    public double getChanceEmptyField() {
        return chanceEmptyField;
    }

    public double getChanceCornField() {
        return chanceCornField;
    }

    public ArrayList<ArrayList<MapField>> getFinalGameMap() {
        return finalGameMap;
    }

    public void setFinalGameMap(ArrayList<ArrayList<MapField>> finalGameMap) {
        this.finalGameMap = finalGameMap;
    }

    public void setGameHamster(Hamster gameHamster) {
        this.gameHamster = gameHamster;
    }
}

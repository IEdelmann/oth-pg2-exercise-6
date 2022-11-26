import java.util.ArrayList;
import java.util.Random;

public class GameMap {
    private final int xDimension;
    private final int yDimension;
    private final double chanceWallField;
    private final double chanceEmptyField;
    private final double chanceCornField;
    private ArrayList<ArrayList<MapField>> finalGameMap;

    // When creating a 'GameMap' object, the dimensions have to be set but the default chances for various field types are applied;
    public GameMap(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        // WallField = 40%, EmptyField = 50%, CornField = 10%;
        this.chanceWallField = chanceConverter(yDimension, 40) - 1;
        this.chanceEmptyField = chanceConverter(yDimension, 50) - 1;
        this.chanceCornField = chanceConverter(yDimension, 10) - 1;
        this.finalGameMap = generateMap(this.xDimension, this.yDimension);
    }

    // Constructor for generating the game map with customized field type chances;
    public GameMap(int xDimension, int yDimension, int chanceWallField, int chanceCornField, int chanceEmptyField) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.chanceWallField = chanceConverter(yDimension, chanceWallField) - 1;
        this.chanceCornField = chanceConverter(yDimension, chanceCornField) - 1;
        this.chanceEmptyField = chanceConverter(yDimension, chanceEmptyField) - 1;
        this.finalGameMap = generateMap(this.xDimension, this.yDimension);
    }

    private void spawnHamster(ArrayList<ArrayList<MapField>> generatedMap) {
        int spawnColumnCoordinate = 1;
        int spawnRowCoordinate = this.getYDimension() - 2;

        generatedMap.get(spawnRowCoordinate).remove(1);
        generatedMap.get(spawnRowCoordinate).add(1, new Hamster(spawnRowCoordinate, spawnColumnCoordinate));
    }

    // Simply breaks down the field type chances down to the actually available amount of fields;
    private double chanceConverter(int y, int chance) {
        return ((double)y * chance) / 100;
    }

    // Returns a random value between 0 and the given parameter - 1;
    private int randomChance(int maxValue) {
        Random random = new Random();

        return random.nextInt(maxValue);
    }

    // Goes through the game map ArrayLists and instructs every field object to print its symbol;
    public void printGameMap() {
        for (int x = 0; x < this.xDimension; x++) {

            for (int y = 0; y < this.yDimension; y++) {

                this.finalGameMap.get(x).get(y).printSymbol();
            }
            System.out.println();
        }
    }

    // Only for testing purposes, print the field objects x/y coordinates;
    public void printGameMapCoordinates() {
        for (int x = 0; x < this.xDimension; x++) {

            for (int y = 0; y < this.yDimension; y++) {
                int[] temp = this.finalGameMap.get(x).get(y).getFieldCoordinates().getCoordinate();
                System.out.print("(" + temp[0] + "/" + temp[1] + ") ");
            }
            System.out.println();
        }
    }

    // Generates the whole game map;
    private ArrayList<ArrayList<MapField>> generateMap(int xDimension, int yDimension) {
        ArrayList<ArrayList<MapField>> generatedMap = new ArrayList<>();

        generatedMap.add(generateWallTypeRow(yDimension, 0));       // The first row is always filled with WallType objects;

        for (int x = 1; x < xDimension - 2; x++) {
            generatedMap.add(generateRandomRow(yDimension, x));
        }

        // Generate a row filled with EmptyField objects to safely spawn the hamster object;
        generatedMap.add(generateEmptyTypeRow(yDimension, xDimension - 2));

        generatedMap.add(generateWallTypeRow(yDimension, xDimension - 1)); // The last row is always filled with WallType objects;

        // Spawn the hamster object into the game map;
        spawnHamster(generatedMap);

        return generatedMap;
    }

    private ArrayList<MapField> generateRandomRow(int y, int rowPosition) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        generatedArray.add(new WallField(rowPosition, 0)); // The first object of every row is a WallType object;

        int randomFieldType;

        // Splits the changes of the various field types into a 'range';
        double wallTypeLine = this.chanceWallField;
        double emptyTypeLine = wallTypeLine + this.chanceEmptyField;
        double cornTypeLine = y - 2; // The given y-dimension is always *1* larger than is actually possible - 10 yields a range from 0 to 9;

        // Fills the ArrayList with random field type objects;
        for (int i = 1; i < y - 1; i++) {   // y - 1 because there has to be room for the last field as it is supposed to be a WallField object;
            randomFieldType = randomChance(y - 1); // '-1' because... see the comment above;

            if (randomFieldType <= wallTypeLine) {
                generatedArray.add(new WallField(rowPosition, i));
                continue;
            }

            if (randomFieldType <= emptyTypeLine) {
                generatedArray.add(new EmptyField(rowPosition, i));
                continue;
            }

            if (randomFieldType <= cornTypeLine) {
                generatedArray.add(new CornField(rowPosition, i));
            }
        }

        // The last field type object in every array is a WallType object;
        generatedArray.add(new WallField(rowPosition, y - 1));

        return generatedArray;
    }

    // Return a ArrayList completely filled with WallType objects;
    private ArrayList<MapField> generateWallTypeRow(int y, int rowPosition) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            generatedArray.add(new WallField(rowPosition, i));
        }

        return generatedArray;
    }

    // Return a ArrayList completely filled with EmptyType objects;
    private ArrayList<MapField> generateEmptyTypeRow(int y, int rowPosition) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        generatedArray.add(new WallField(rowPosition, 0));

        // y - 1 because the last field type has to be WallType object;
        for (int i = 1; i < y - 1; i++) {
            generatedArray.add(new EmptyField(rowPosition, i));
        }

        // The last field type is a WallType object;
        generatedArray.add(new WallField(rowPosition, y - 1));

        return generatedArray;
    }

    public int getXDimension() {
        return xDimension;
    }

    public int getYDimension() {
        return yDimension;
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
}

import java.util.ArrayList;
import java.util.Random;

public class GameMap {
    private final int xDimension;
    private final int yDimension;
    private final double chanceWallField;
    private final double chanceEmptyField;
    private final double chanceCornField;
    private ArrayList<ArrayList<MapField>> doubleArray;

    public GameMap(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.chanceWallField = chanceConverter(yDimension, 40) - 1;
        this.chanceEmptyField = chanceConverter(yDimension, 40) - 1;
        this.chanceCornField = chanceConverter(yDimension, 20) - 1;
    }

    public GameMap(int xDimension, int yDimension, int chanceWallField, int chanceCornField, int chanceEmptyField) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        this.chanceWallField = chanceConverter(yDimension, chanceWallField) - 1;
        this.chanceCornField = chanceConverter(yDimension, chanceCornField) - 1;
        this.chanceEmptyField = chanceConverter(yDimension, chanceEmptyField) - 1;
    }

    private double chanceConverter(int y, int chance) {
        return ((double)y * chance) / 100;
    }

    private int randomChance(int maxValue) {
        Random random = new Random();

        return random.nextInt(10);
    }

    private ArrayList<MapField> generateRowInBetween(int y, int rowPosition) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        generatedArray.add(new WallField(rowPosition, 0));

        int randomFieldType;
        double wallTypeLine = this.chanceWallField;
        double emptyTypeLine = wallTypeLine + this.chanceEmptyField;
        double cornTypeLine = emptyTypeLine + this.chanceCornField;

        for (int i = 1; i < y; i++) {
            randomFieldType = randomChance(y);

            if (randomFieldType <= wallTypeLine) {
                generatedArray.add(new WallField(rowPosition, i));
            }

            if (randomFieldType <= emptyTypeLine) {
                generatedArray.add(new EmptyField(rowPosition, i));
            }

            if (randomFieldType <= cornTypeLine) {
                generatedArray.add(new CornField(rowPosition, i));
            }
        }

        return generatedArray;
    }

    private ArrayList<MapField> generateFirstAndLastRow(int y, int rowPosition) {
        ArrayList<MapField> generatedArray = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            generatedArray.add(new WallField(rowPosition, i));
        }

        return generatedArray;
    }
}

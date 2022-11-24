import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<MapField>> testMapRows = new ArrayList<>();
        ArrayList<MapField> testMapColumns = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testMapRows.add(new ArrayList<MapField>());
        }

        WallField myWallField = new WallField(1, 2);
        EmptyField myEmptyField = new EmptyField();
        CornField myCornField = new CornField();

        myWallField.printSymbol();
        System.out.println("Wall consumable: " + myWallField.isConsumable());
        System.out.println("Wall passable: " + myWallField.isPassable());

        myEmptyField.printSymbol();
        System.out.println("Empty consumable: " + myEmptyField.isConsumable());
        System.out.println("Empty passable: " + myEmptyField.isPassable());

        myCornField.printSymbol();
        System.out.println("Corn consumable: " + myCornField.isConsumable());
        System.out.println("Corn passable: " + myCornField.isPassable());
        System.out.println();
        System.out.println();

        GameMap myGameMap = new GameMap(10, 10);

        myGameMap.printGameMap();
        System.out.println();

        myGameMap.printGameMapCoordinates();
        System.out.println();
        System.out.println();

        GameMap largeGameMap = new GameMap(20, 20, 10, 20, 70);
        largeGameMap.printGameMap();
        System.out.println();
        largeGameMap.printGameMapCoordinates();


//        for (int j = 0; j < 10; j++) {
//
//            for (int k = 0; k < 5; k++) {
//                testMapRows.get(j).get(0).printSymbol();
//            }
//
//            System.out.println();
//        }


//        for (int k = 0; k < 10; k++) {
//
//            for (int l = 0; l < 10; l++) {
//
//                testMapColumns.add(new WallField());
//            }
//            testMapRows.add(testMapColumns);
//        }
//
//        for (int n = 0; n < 10; n++) {
//
//            for (int o = 0; o < 10; o++) {
//                testMapRows.get(n).get(o).printSymbol();
//            }
//            System.out.println();
//        }



//        int[][] myArray = {{10, 30 , 50, 70}, {20, 40, 60, 80}, {5, 15, 25, 35}};
//
//        for (int i = 0; i < myArray.length; i++) {
//
//            for (int j = 0; j < myArray[i].length; j++) {
//
//                System.out.print(myArray[i][j] + " ");
//            }
//
//            System.out.println();
//        }
    }
}
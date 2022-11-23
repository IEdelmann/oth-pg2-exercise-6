import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<MapField>> testMapRows = new ArrayList<>();
        ArrayList<MapField> testMapColumns = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testMapRows.add(new ArrayList<MapField>());
        }

        testMapRows.get(0).add(new WallField());
        testMapRows.get(1).add(new WallField());
        testMapRows.get(2).add(new WallField());
        testMapRows.get(3).add(new WallField());
        testMapRows.get(4).add(new WallField());
        testMapRows.get(5).add(new WallField());
        testMapRows.get(6).add(new WallField());
        testMapRows.get(7).add(new WallField());
        testMapRows.get(8).add(new WallField());
        testMapRows.get(9).add(new WallField());

        for (int j = 0; j < 10; j++) {

            for (int k = 0; k < 5; k++) {
                testMapRows.get(j).get(0).printSymbol();
            }

            System.out.println();
        }


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
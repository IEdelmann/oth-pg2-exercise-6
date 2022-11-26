import myUtilities.UserInput;

public class Main {

    public static void main(String[] args) {

//        GameMap myGameMap = new GameMap(10, 10);  // Map with 10x10 dimensions and default field type chances;
//        myGameMap.printGameMap();                 // For testing purposes only - prints all the coordinates;

        GameMap gameMapDynamicChances = new GameMap(15,15, 30, 10, 60);
        Hamster hamster = gameMapDynamicChances.getGameHamster();
//        gameMapDynamicChances.printGameMapCoordinates();      // For testing purposes only - prints all the coordinates;

        printIntro();

        boolean runTimeFlag = true;
        UserInput userInput = new UserInput();
        char directionInput;

        while (runTimeFlag) {
            gameMapDynamicChances.printGameMap();
            System.out.println("Corns eaten: " + hamster.getCornEaten());

            directionInput = userInput.userInputString("Direction: ", "[w, a, s, d, x]", 1).charAt(0);

            if (directionInput == 'x') {
                System.out.println("Thank you for playing the official xHamster game :D");
                runTimeFlag = false;
            }

            gameMapDynamicChances.moveHamster(directionInput);
        }
    }

    public static void printIntro() {
        System.out.println("Welcome to the xHamster game!");
        System.out.println("You can maneuver by 'w', 'a', 's' and 'd'.");
        System.out.println("Eat as many as possible corns '*'.");
        System.out.println("To exit the game enter 'x' - that is why the game's called xHamster... in case you were wondering...\n");
    }
}
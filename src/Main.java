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

            directionInput = userInput.userInputString("Direction: ", "[w, a, s, d, y]", 1).charAt(0);

            // Prints 50 new lines to display the game better;
//            System.out.println(new String(new char[50]).replace("\0", "\r\n"));

            if (directionInput == 'y') {
                System.out.println("Thank you for playing the official yHamster game :D\n");
                runTimeFlag = false;
            }

            gameMapDynamicChances.moveHamster(directionInput);
        }
    }

    public static void printIntro() {
        System.out.println("\nWelcome to the yHamster game!");
        System.out.println("You can maneuver by 'w', 'a', 's' and 'd'.");
        System.out.println("Eat as many corns '*' as possible.");
        System.out.println("To exit the game enter 'y' - that is why the game's called yHamster.");
        System.out.println("To avoid legal issues with a large online platform of adult videos, I have decided to call now the game 'yHamster' instead of the original name.\n");
    }
}
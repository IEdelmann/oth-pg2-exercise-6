import myUtilities.UserInput;

import java.util.Arrays;

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
        int[] redPillRouteCoordinates = GameMap.matrixExit.getCoordinates();

        while (runTimeFlag) {
            gameMapDynamicChances.printGameMap();
            System.out.println("Corn eaten: " + hamster.getCornEaten());

            // For the 'rat race' route;
            if (CornField.cornSpawn == 0) {
                System.out.println("You made it! You actually ate all the corn... what an achievement.\n");
                break;
            }

            // For the 'red pill' route - it's not a bug, it's a feature!
            if (Arrays.equals(hamster.getFieldCoordinates().getCoordinates(), redPillRouteCoordinates)) {
//                System.out.println("So... you finally decided to take the red pill and exit the Matrix.");
//                System.out.println("This is the TRUE ending to this game!\n");
                System.out.println("""
                        \nThis is your last chance. After this, there is no turning back.
                         You take the blue pill - the story ends, you wake up in your bed and believe whatever you want to believe.
                         You take the red pill - you stay in Wonderland and I show you how deep the rabbit-hole goes.
                        """);

                // Opting the 'break' out, makes in this route actually sense :P
//                break;
            }

            directionInput = userInput.userInputString("Direction: ", "[w, a, s, d, y]", 1).charAt(0);

            // Prints 50 new lines to display the game better;
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));

            // For the 'lazy' route;
            if (directionInput == 'y') {
                System.out.println("Thank you for playing the official yHamster game :D\n");
                break;
            }

            gameMapDynamicChances.moveHamster(directionInput);
        }
    }

    public static void printIntro() {
        System.out.println("\nWelcome to the yHamster game!");
        System.out.println("You can maneuver by 'w', 'a', 's' and 'd'.");
        System.out.println("You can eat as many corn '*' as you like - eat all to win the game.");
        System.out.println("To exit the game enter 'y' - that is why the game's called yHamster.");
        System.out.println("(To avoid legal issues with a large online platform for adult videos, I have now decided to call the game 'yHamster' instead of my original idea.)\n");
    }
}
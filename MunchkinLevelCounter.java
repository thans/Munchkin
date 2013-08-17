/**
 * This class is a command-line interactive program for tracking a player's levels in the game of
 * Munchkin.  Players are prompted for their levels, gear, and temporary changes.
 * Intended to be used with the game of Munchkin (this is not a stand-alone game!):
 * http://en.wikipedia.org/wiki/Munchkin_(card_game)
 * http://www.amazon.com/Steve-Jackson-Games-1408SJG-Munchkin/dp/1556344732/ref=sr_1_3?ie=UTF8&qid=1376701323&sr=8-3&keywords=munchkin
 * 
 * This {@link MunchkinLevelCounter} was inspired by the MunchkinLevelCounter app for android/iOS
 * Munchkin is a copyright of Steve Jackson Games.
 * This program is not affiliated in any way with Steve Jackson Games.
 * 
 * @author Tore Hanssen
 */
import java.util.Scanner;

public class MunchkinLevelCounter {
    
    // public static final String[] VALID_COMMANDS = [];
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = getName(console);
        LevelCounter levelTracker = new LevelCounter();
        Boolean exit = false;
        String command = "";
        while (!exit && levelTracker.getLevel() < 10) {
            printCurrentState(levelTracker);
            command = promptCommand(console, name);
            if (command.equals("quit") || command.startsWith("q")) {
                exit = true;
            } else if (command.startsWith("q") || command.equals("quit") || command.startsWith("t") ||
                          command.startsWith("g") || command.startsWith("l") || command.startsWith("r")) {
                updateGame(command, console, levelTracker);
            } else {
                System.out.println("Command not recognized.");
            }
        }
        if (levelTracker.getLevel() >= 10) {
            System.out.println("You win! Congratulations!");
        } else {
            System.out.println("Thanks for playing " + name + ".");
            // TODO care to tell me who won and who was playing?
            
        }

    }

    /**
     * Prompts the user for a task.  Valid tasks include:
     * Changing level, changing gear, changing temporary points, and resetting temporary points
     * @param console the scanner to use
     * @param name the name of the player
     * @return the command the user issued
     */
    private static String promptCommand(Scanner console, String name) {
        System.out.println("What would you like to do, " + name + "?");
        System.out.println("(type \"quit\" to quit)");
        System.out.println("Change (L)evel");
        System.out.println("Change (G)ear");
        System.out.println("Change (T)emporary Points");
        System.out.println("(R)eset Temporary Points");
        System.out.println("(P)rint Current Game State");
        
        System.out.print(">> ");
        String command = console.nextLine().toLowerCase();
        return command;
    }


    /**
     * Updates the state of the game based on user input
     * @param command the command issued by the user
     * @param console the scanner to use for user input
     * @param counts the {@link LevelCounter} to use
     */
    private static void updateGame(String command, Scanner console, LevelCounter counts) {
        if (command.startsWith("l")) {
            System.out.println("How much do you want to change your level by?");
            System.out.print(">> ");
            int deltaLevel = console.nextInt();
            counts.changeLevel(deltaLevel);
        } else if (command.startsWith("g")) {
            System.out.println("How much do you want to change your gear by?");
            System.out.print(">> ");
            int deltaGear = console.nextInt();
            counts.changeGear(deltaGear);
        } else if (command.startsWith("t")) {
            System.out.println("How much do you want to change your temp by?");
            System.out.print(">> ");
            int deltaTemp = console.nextInt();
            counts.changeBonus(deltaTemp);
        } else if (command.startsWith("r")) {
            counts.resetBonus();
        }
        console.nextLine();
    }

    /**
     * Outputs the current state of the player's level, gear, bonus, and combat strength
     * @param counts the player's {@link LevelCounter}
     */
    private static void printCurrentState(LevelCounter counts) {
        System.out.println("Current Level: " + counts.getLevel());
        System.out.println("Current Gear: " + counts.getGear());
        System.out.println("Current +/-: " + counts.getBonus());
        System.out.println("---------------------------");
        System.out.println(" Current Combat Ability: " + counts.getCombatStrength());
        System.out.println("---------------------------");
    }

    /**
     * Prints an introductory message and gets the player's name
     * @param console the scanner to use for user input
     * @return the name of the player
     */
    private static String getName(Scanner console) {
        System.out.println("Welcome to the Munchkin Level Counter!");
        System.out.println("Good luck in your game");
        System.out.print("What would you like your name to be this round? ");
        String name = console.nextLine();
        return name;
    }
}
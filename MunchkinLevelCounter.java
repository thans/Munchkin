// Helene Martin, CSE 143
// A basic Swing graphical user interface.  See chapter 14 of the book for more
// on building complex user interfaces.
import java.awt.*;
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
        if (levelTracker.getLevel() <= 10) {
            System.out.println("You win! Congratulations!");
        } else {
            System.out.println("Thanks for playing " + name);
            // TODO care to tell me who won and who was playing?
            
        }

    }

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
        } else if (command.startsWith("p")) {
            // TODO
        }
        console.nextLine();
        System.out.println("updated game state");
    }



    private static void printCurrentState(LevelCounter counts) {
        // TODO Auto-generated method stub
        System.out.println("Current Level: " + counts.getLevel());
        System.out.println("Current Gear: " + counts.getGear());
        System.out.println("Current +/-: " + counts.getBonus());
        System.out.println("---------------------------");
        System.out.println(" Current Combat Ability: " + counts.getCombatStrength());
        System.out.println("---------------------------");
    }



    private static String getName(Scanner console) {
        System.out.println("Welcome to the Munchkin Level Counter!");
        System.out.println("Good luck in your game");
        System.out.print("What would you like your name to be this round? ");
        String name = console.nextLine();
        return name;
    }
}
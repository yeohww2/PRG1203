import java.util.Scanner;

public class Player {
    private String name;
    private Boat boat;
    private int turns;

    public Player(String nm, Boat bo) {
        name = nm;
        boat = bo;
        turns = 0;
        chooseBoatColor();
    }

    public String getName() {
        return name;
    }

    public Boat getBoat() {
        return boat;
    }

    public int getTurns() {
        return turns;
    }

    public void incrementTurns() {
        turns++;
    }

    public void takeTurn(Dice dice, River river) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(name + ", press 'R' to roll the dice: ");
        while (true) {
            String rollKey = scanner.nextLine().toUpperCase();
            if (rollKey.equals("R")) {
                int diceRoll = dice.roll();
                System.out.println(name + " rolled a " + diceRoll + "!");

                int newPosition = boat.getLocation() + diceRoll;
                if (newPosition >= river.getRiverLength()) {
                    newPosition = river.getRiverLength() - 1;
                }

                RiverObject obstacle = river.getObstacle(newPosition);
                System.out.println("Moving to position " + newPosition + ". Obstacle: " + obstacle.getSymbol());

                if (obstacle instanceof Trap) {
                    int strength = obstacle.getStrength();
                    System.out.println("Hit a trap! Moving back " + strength + " steps.");
                    newPosition -= strength;
                    if (newPosition < 0) {
                        newPosition = 0;
                    }
                } else if (obstacle instanceof Current) {
                    int strength = obstacle.getStrength();
                    System.out.println("Caught in a current! Moving forward " + strength + " steps.");
                    newPosition += strength;
                    if (newPosition >= river.getRiverLength()) {
                        newPosition = river.getRiverLength() - 1;
                    }
                }

                boat.setLocation(newPosition);
                System.out.println(name + "'s current location: " + newPosition);
                break;
            } else {
                System.out.println("Invalid input. Press 'R' to roll the dice: ");
              
            }
        }
    }
    
    public void chooseBoatColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", choose your boat color:");
        System.out.println("G: Green, B: Blue, R: Red (default: Yellow)");
        String colorChoice = scanner.nextLine().toUpperCase();

        switch (colorChoice) {
            case "G":
                boat.setColor('G');
                break;
            case "B":
                boat.setColor('B');
                break;
            case "R":
                boat.setColor('R');
                break;
            default:
                boat.setColor('Y');
                break;
        }

        System.out.println(name + ", you have chosen the " + getBoatColorName(boat.getColor()) + " color boat.");
    }
    
    private String getBoatColorName(char color) {
        switch (color) {
            case 'G':
                return "Green";
            case 'B':
                return "Blue";
            case 'R':
                return "Red";
            default:
                return "Yellow";
        }
    }
}

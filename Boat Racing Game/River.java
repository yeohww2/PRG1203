import java.util.Arrays;
import java.util.Random;

public class River {
    private RiverObject[] obstacles;
    private int riverLength;
    private char[] riverTrack;

    public River(int riverLength) {
        this.riverLength = riverLength;
        this.obstacles = new RiverObject[riverLength];
        generateRiver();
    }

     private void generateRiver() {
        Arrays.fill(obstacles, new EmptySpace());

        Random random = new Random();
        int numCurrents = riverLength / 10;
        int numTraps = riverLength / 10;

        for (int i = 0; i < numCurrents; i++) {
            int randomIndex = random.nextInt(riverLength-1);
            while (!(obstacles[randomIndex] instanceof EmptySpace)) {
                randomIndex = random.nextInt(riverLength-1);
            }
            obstacles[randomIndex] = new Current();
        }

        for (int i = 0; i < numTraps; i++) {
            int randomIndex = random.nextInt(riverLength-1);
            while (!(obstacles[randomIndex] instanceof EmptySpace)) {
                randomIndex = random.nextInt(riverLength-1);
            }
            obstacles[randomIndex] = new Trap();
        }
    }
    
    public int getRiverLength() {
        return riverLength;
    }
    
    public RiverObject getObstacle(int position) {
        if (position < 0 || position >= riverLength) {
            return new EmptySpace();
        }
        return obstacles[position];
    }

    public void displayPosition(Player player1, Player player2) {
        int p1Location = player1.getBoat().getLocation();
        int p2Location = player2.getBoat().getLocation();

        for (int i = 0; i < riverLength; i++) {
            if (i == p1Location && i == p2Location) {
                System.out.print(player1.getBoat().getColorFirstLetter() + player2.getBoat().getColorFirstLetter());
            } else if (i == p1Location) {
                System.out.print(" " + player1.getBoat().getColorFirstLetter() + " ");
            } else if (i == p2Location) {
                System.out.print(" " + player2.getBoat().getColorFirstLetter() + " ");
            } else {
                System.out.print(" " + obstacles[i].getSymbol() + "  ");
            }
        }
        System.out.println();
    }
    
}


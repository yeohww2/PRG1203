import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Boat Game !");
        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();

        Boat boat1 = new Boat();
        Player player1 = new Player(player1Name, boat1);

        Boat boat2 = new Boat();
        Player player2 = new Player(player2Name, boat2);
        
        River river = new River(101);

        Dice dice = new Dice(6);
        
        LeaderBoard leaderBoard = new LeaderBoard();  
        
        System.out.println("Start game");

        while (true) {
            river.displayPosition(player1, player2);

            System.out.println(player1.getName() + ", it's your turn.");
            player1.takeTurn(dice, river);
            player1.incrementTurns();

            if (player1.getBoat().getLocation() >= 100) {
            	player1.getBoat().setLocation(river.getRiverLength() - 1);
                System.out.println(player1.getName() + " wins!");
                leaderBoard.addTopScore(player1.getName(), player1.getTurns());
                break;
            }

            river.displayPosition(player1, player2);

            System.out.println(player2.getName() + ", it's your turn.");
            player2.takeTurn(dice, river);
            player2.incrementTurns();
 
            if (player2.getBoat().getLocation() >= 100) {
            	player2.getBoat().setLocation(river.getRiverLength() - 1);
                System.out.println(player2.getName() + " wins!");
                leaderBoard.addTopScore(player2.getName(), player2.getTurns());
                break;
            }
        }
        
        
        leaderBoard.displayTopScores();
        
    }
}

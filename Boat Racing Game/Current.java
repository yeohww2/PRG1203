import java.util.Random;

public class Current extends RiverObject {
    private int strength;

    public Current() {
        super('C');
        Random random = new Random();
        strength = random.nextInt(6) + 1;
    }

    @Override
    public int getStrength() {
        return strength;
    }
    
    public void hitCurrent(Player player) {
        player.getBoat().moveForward(strength); // Move backward based on trap strength
        System.out.println(player.getName() + "'s boat hit a current! Moving forward " + strength + " steps.");
    }
}

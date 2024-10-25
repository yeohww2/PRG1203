import java.util.Random;

public class Dice {
    private Random random;
    private int sides;

    public Dice(int sides) {
        random = new Random();
        this.sides = sides;
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}

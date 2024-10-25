public abstract class RiverObject {
    private char symbol;

    public RiverObject(char sm) {
        symbol = sm;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract int getStrength();
}

public class Boat {
    private int location;
    private char color;
    private int boatNum;
    private String playerName;

    public Boat() {
        location = 1;
        color = 'Y';
        boatNum = 1;
    }

    public Boat(int lo, char c, int bn) {
        location = lo;
        color = c;
        boatNum = bn;
    }

    public int getLocation() {
        return location;
    }
    
    public void setLocation(int lo) {
        location = lo;
    }

    public int getBoatNum() {
        return boatNum;
    }

    public void setBoatNum(int bn) {
        boatNum = bn;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char c) {
        color = c;
    }
    
    public String getPlayerName() { 
        return playerName;
    }
    
    public void moveForward(int steps) {
        location += steps;
    }

    public void moveBackward(int steps) {
        location -= steps;
    }
    
    public char getColorFirstLetter() {
        return color;
    }
    
    @Override
    public String toString() {
        return String.format("Boat number %d controlled by %s is currently at %d!", boatNum, playerName, location);
    }
}

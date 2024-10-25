import java.io.*;
import java.util.*;

public class LeaderBoard {
    private List<Score> topScores;

    public LeaderBoard() {
        this.topScores = new ArrayList<>();
        loadTopScores();
    }

    private void loadTopScores() {
        try (Scanner fileScanner = new Scanner(new File("TopScore.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0];
                    int score = Integer.parseInt(data[1]);
                    topScores.add(new Score(name, score));
                }
            }
        } catch (FileNotFoundException e) {
            // File not found, ignore and create a new one when needed
        }
        Collections.sort(topScores);
    }

    private void saveTopScores() {
        try (PrintWriter writer = new PrintWriter(new File("TopScore.txt"))) {
            for (Score score : topScores) {
                writer.println(score.getName() + "," + score.getScore());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isTopScore(int score) {
        return topScores.size() < 5 || score < topScores.get(topScores.size() - 1).getScore();
    }

    public void addTopScore(String name, int score) {
        topScores.add(new Score(name, score));
        Collections.sort(topScores);

        if (topScores.size() > 5) {
            topScores.remove(topScores.size() - 1);
        }

        saveTopScores();
    }

    public void displayTopScores() {
        System.out.println("\nTop 5 Scores:");
        for (Score score : topScores) {
            System.out.println(score.getName() + ": " + score.getScore());
        }
    }
}

class Score implements Comparable<Score> {
    private String name;
    private int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Score other) {
        return Integer.compare(this.score, other.score);
    }
}

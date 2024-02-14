package model;

/**
 * Class representing a player in the game.
 */
public class Player {
    private String name;
    private int score;

    /**
     * Constructor for Player.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Method representing a player's move in the game.
     *
     * @param row The row where the player makes a move.
     * @param col The column where the player makes a move.
     */
    public void play(int row, int col) {
        // Implement player's play logic
    }
}
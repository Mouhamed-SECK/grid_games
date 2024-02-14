/**
 * Interface defining the methods for game view interaction.
 */
public interface IView {
    /**
     * Renders the game view.
     */
    void render();

    /**
     * Displays the game over message.
     */
    void finishGame();

    /**
     * Gets the move from the player.
     * @return the player's move
     */
    int getPlayerMove();

    /**
     * Displays the game choice menu.
     * @return the game choice selected by the player
     */
    int displayGameChoice();

    /**
     * Updates the view.
     */
    void update();

    /**
     * Displays the current player's turn.
     */
    void displayCurrentPlayer();

    /**
     * Displays the game over message.
     */
    void displayGameOver();

    /**
     * Displays an error if the move is invalid.
     */
    void displayErrorMove();
}

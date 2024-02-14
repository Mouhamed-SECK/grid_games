package model;

import java.io.File;
import java.io.IOException;

/**
 * Singleton class for managing scores.
 */
public class ScoreManager {
    private static ScoreManager instance;
    private File file;

    private ScoreManager(File file) {
        this.file = file;
    }

    /**
     * Get the instance of ScoreManager (Singleton pattern).
     *
     * @param file The file used for storing scores.
     * @return The instance of ScoreManager.
     */
    public static ScoreManager getInstance(File file) {
        if (instance == null) {
            instance = new ScoreManager(file);
        }
        return instance;
    }

    /**
     * Read scores from the file.
     *
     * @return The file containing scores.
     * @throws IOException if there's an issue reading the file.
     */
    public File readFile() throws IOException {
        // Implement file reading logic
        return file;
    }

    /**
     * Save scores to the file.
     *
     * @param file The file to save scores.
     * @throws IOException if there's an issue saving the file.
     */
    public void saveFile(File file) throws IOException {
        // Implement file saving logic
    }

    /**
     * Read the score for a specific player.
     *
     * @param player The player for whom the score is to be read.
     * @return The score of the player.
     */
    public int readScore(Player player) {
        // Implement reading score logic
        return player.getScore();
    }

    /**
     * Set the score for a specific player.
     *
     * @param player The player for whom the score is to be set.
     */
    public void setScore(Player player) {
        // Implement setting score logic
    }
}
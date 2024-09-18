package at.ac.tgm.llist.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordPicturePairTest {
    WordPicturePair pair1;

    @Test
    @DisplayName("Initialize WordPicturePair with valid parameters")
    void testValidParams() {
        assertDoesNotThrow(() -> {
            pair1 = new WordPicturePair("https://github.githubassets.com/assets/GitHub-Mark-ea2971cee799.png", "github");
        });
    }

    @Test
    @DisplayName("Initialize WordPicturePair with invalid URL")
    void testInvalidUrl() {
        // Invalid URL
        assertThrows(IllegalArgumentException.class, () -> {
            pair1 = new WordPicturePair("github", "github");
        });
        // null URL
        assertThrows(IllegalArgumentException.class, () -> {
            pair1 = new WordPicturePair(null, "github");
        });
    }

    @Test
    @DisplayName("Initialize WordPicturePair with invalid word")
    void testEmptyWord() {
        // empty word
        assertThrows(IllegalArgumentException.class, () -> {
            pair1 = new WordPicturePair("https://github.githubassets.com/assets/GitHub-Mark-ea2971cee799.png", "");
        });
        // null word
        assertThrows(IllegalArgumentException.class, () -> {
            pair1 = new WordPicturePair("https://github.githubassets.com/assets/GitHub-Mark-ea2971cee799.png", null);
        });
    }
}

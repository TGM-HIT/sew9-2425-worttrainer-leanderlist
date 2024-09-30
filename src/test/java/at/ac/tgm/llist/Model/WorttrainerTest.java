package at.ac.tgm.llist.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class WorttrainerTest {
    Worttrainer wt1;

    @BeforeEach
    void setup() {
        wt1 = new Worttrainer();
    }

    @Test
    @DisplayName("Select invalid index for picturepair")
    void testInvalidIndex() {
        assertThrows(
                IllegalArgumentException.class,
                () -> { wt1.selectPair(5); }
        );
    }

    @Test
    @DisplayName("Check with correct and incorrect Answer")
    void testCorrectIncorrectAnswers() {
        assertTrue(wt1.checkAnswer(wt1.getPairList().get(wt1.getSelectedPair()).getWord()));
        assertFalse(wt1.checkAnswer("wrong"));
    }

    @Test
    @DisplayName("Check if counts are correct")
    void testCounts() {
        wt1.selectRandomPair();
        int index = wt1.getSelectedPair();
        wt1.checkAnswer(wt1.getPairList().get(index).getWord());
        assertEquals(1, wt1.getCorrectCount());
        assertEquals(0, wt1.getWrongCount());
        assertEquals(1, wt1.getAnswerCount());
    }


}

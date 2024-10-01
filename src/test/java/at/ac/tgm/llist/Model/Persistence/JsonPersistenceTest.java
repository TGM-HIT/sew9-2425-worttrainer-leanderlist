package at.ac.tgm.llist.Model.Persistence;

import at.ac.tgm.llist.Model.Worttrainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonPersistenceTest {

    private Worttrainer wt;
    private Persistence json;

    @BeforeEach
    void setup() {
        wt = new Worttrainer();
        json = new JsonPersistence();
    }

    @Test
    @DisplayName("Save Worttrainer object and load valid file")
    void testSaveLoad() {
        wt.setCorrectCount(4);
        assertDoesNotThrow(() -> {
            json.save(wt, "src\\test\\java\\at\\ac\\tgm\\llist\\Model\\Persistence\\test.json");
        });
        assertEquals(4, json.load("src\\test\\java\\at\\ac\\tgm\\llist\\Model\\Persistence\\test.json").getCorrectCount());
    }
}

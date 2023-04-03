package foodtruckfrenzy.Drawable.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ScoreValueTest {
    ScoreValue scoreValue;

    @BeforeEach
    void setup() {
        scoreValue = new ScoreValue(null, 0);
    }

    @Test
    void testGetScoreType() {
        assertNull(scoreValue.getScoreType());
        for (ScoreType score : ScoreType.values()) {
            scoreValue = new ScoreValue(score, 0);
            assertEquals(score, scoreValue.getScoreType());
        }
    }

    @Test
    void testGetValue() {
        for (int i = 0; i < 10; i++) {
            scoreValue = new ScoreValue(null, i);
            assertEquals(i, scoreValue.getValue());
        }
    }
}

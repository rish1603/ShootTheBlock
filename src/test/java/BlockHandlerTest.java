import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BlockHandlerTest extends BlockHandler{

    @Test
    public void test_hitDetection() {

        Block block = new Block();

        block.setX(50);
        block.setY(50);

        // Test that accurate click hits:
        setMouseClickX(60);
        setMouseClickY(60);
        assertTrue(blockIsClicked(block));

        // Test that unaccurate click misses:
        setMouseClickX(40);
        setMouseClickY(40);
        assertFalse(blockIsClicked(block));
    }
}

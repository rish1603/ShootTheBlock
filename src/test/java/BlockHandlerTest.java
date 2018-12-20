import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BlockHandlerTest {

    @Test
    public void test_hitDetection() {

        Block block = new Block();
        BlockHandler handler = new BlockHandler();

        block.setX(50);
        block.setY(50);

        // Test that accurate click hits:
        handler.setMouseClickX(60);
        handler.setMouseClickY(60);
        assertTrue(handler.blockIsClicked(block));

        // Test that unaccurate click misses:
        handler.setMouseClickX(40);
        handler.setMouseClickY(40);
        assertFalse(handler.blockIsClicked(block));
    }
}

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WindowTest {

    @Mock
    Game game;

    Window window;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        window = new Window(Constants.GAME_NAME, game);
    }

    @Test
    public void testWindowTitle() {
        assertEquals(window.frame.getTitle(), Constants.GAME_NAME);
        assertEquals(window.frame.getDefaultCloseOperation(), JFrame.EXIT_ON_CLOSE);
    }

    @Test
    public void testWindowDimensions() {
        Dimension dimension = new Dimension(Constants.INITIAL_WIDTH, Constants.INITIAL_HEIGHT);
        assertEquals(window.frame.getSize(), dimension);
    }

    @Test
    public void testWindowNotResizable() {
        assertFalse(window.frame.isResizable());
    }

    @Test
    public void testWindowCloseOperation() {
        assertEquals(window.frame.getDefaultCloseOperation(), JFrame.EXIT_ON_CLOSE);
    }
    @Test
    public void testWindowVisibility() {
        assertTrue(window.frame.isVisible());

    }

}

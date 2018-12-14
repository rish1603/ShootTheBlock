import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BlockTest {

    @Mock
    Graphics g;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBlockColour() {
        Block block = new Block();
        block.render(g);
        verify(g).setColor(Color.BLACK);
        when(g.getColor()).thenReturn(Color.BLACK);
        assertEquals(g.getColor(), Color.BLACK);
    }
}

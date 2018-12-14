import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.mockito.Mockito.verify;

public class HudTest {

    @Mock
    Graphics g;

    private HUD hud;

    @Before
    public void initMocks() {
        hud = new HUD();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHudRendered() {
        hud.render(g);
        verify(g).setColor(Color.BLACK);
        verify(g).setFont(new Font("TimesRoman", Font.BOLD, Constants.FONT_SIZE));
    }
}
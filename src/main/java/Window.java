import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Window {

    protected JFrame frame;

    /**
     * Constructor that calls createFrame to set frame settings
     * @param title Title of the game
     * @param game game instance
     */
    public Window(String title, Game game) {

        frame = createFrame(title);
        frame.add(game);
        game.start();

    }

    /**
     * Method to set frame settings
     * @param title title of the game
     * @return JFrame with settings set e.g. height and width
     */
    public JFrame createFrame(String title) {

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.INITIAL_WIDTH, Constants.INITIAL_HEIGHT);
        frame.setUndecorated(false);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setCursor(Cursor.CROSSHAIR_CURSOR);


        return frame;
    }

    /**
     * Closes the JFrame once the popup has been shown and the game has ended
     */
     public void closeGame() {
         frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
     }
}


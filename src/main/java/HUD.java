import java.awt.*;

public class HUD {

    private BlockHandler handler;

    private int timeRemaining = Constants.GAME_TIME;

    /**
     * Creates HUD object, injects the handler
     * @param handler Block handler object
     */
    public HUD(BlockHandler handler) {
        this.handler = handler;
    }

    /**
     * Renders timer and score onto the screen
     * @param g Graphics object
     * @see Constants to configure HUD variables
     */
    public void render(Graphics g) {
        //set text colour, size and font
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, Constants.FONT_SIZE));

        // draw timer
        g.drawString(Constants.TIME_REMAINING + getTimeRemaining(), Constants.TIMER_X, Constants.TIMER_Y);

        // draw score
        g.drawString(Constants.SCORE + handler.getNumBlocksKilled(), Constants.SCORE_X, Constants.SCORE_Y);
    }

    /**
     * Called by game timer to set time remaining displayed
     * @param timeRemaining time remaining until the end of the game
     */
    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    /**
     * @return time remaining until the end of the game
     */
    public int getTimeRemaining() {
        return timeRemaining;
    }
}

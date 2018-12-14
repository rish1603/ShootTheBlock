import java.awt.*;

public class HUD {

    protected int timeRemaining = Constants.GAME_TIME;
    protected int score;

    public void tick() {

    }

    public void render(Graphics g) {
        //set text colour, size and font
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, Constants.FONT_SIZE));

        // draw timer
        g.drawString(Constants.TIME_REMAINING + getTimeRemaining(), Constants.TIMER_X, Constants.TIMER_Y);
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }
}

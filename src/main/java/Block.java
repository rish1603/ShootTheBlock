import java.awt.*;
import java.util.Random;

public class Block {

    private int x;
    private int y;

    /**
     * Constructor which automatically creates random co-ordinates for the block being created.
     */
    public Block() {
        setX(getRandomNumberInRange(0, Constants.INITIAL_WIDTH - 2*Constants.BLOCK_LENGTH));
        setY(getRandomNumberInRange(100, Constants.INITIAL_HEIGHT - 2*Constants.BLOCK_LENGTH));
    }

    /**
     * Render a block!
     * @param g graphics object
     */
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, Constants.BLOCK_LENGTH, Constants.BLOCK_LENGTH);
    }

    /**
     * Generates a random integer between two numbers. Used to position block.
     * @param min minimum random number
     * @param max maximum random number
     * @return random number larger than minimum but smaller than maximum
     */
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * @return block X co-ordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @param x initialises block X co-ordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return block Y co-ordinate
     */
    public int getY() {
        return y;
    }

    /**
     * @param y initialises block Y co-ordinate
     */
    public void setY(int y) {
        this.y = y;
    }

}

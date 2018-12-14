import java.awt.*;
import java.util.Random;

public class Block {

    protected int x;
    protected int y;

    /**
     * Constructor which automatically creates random co-ordinates for the block being created.
     */
    public Block() {
        x = getRandomNumberInRange(0, Constants.INITIAL_WIDTH - Constants.BLOCK_LENGTH);
        System.out.println("x is at " + x);
        y = getRandomNumberInRange(100, Constants.INITIAL_HEIGHT - Constants.BLOCK_LENGTH);
        System.out.println("y is at " + y);
    }

    public void tick() {

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

}

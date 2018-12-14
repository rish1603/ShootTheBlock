import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Updates and renders all block objects
 */
public class BlockHandler {

    protected int numBlocksKilled = 0;
    protected int numBlocksSpawned = 0;

    LinkedList<Block> blocks = new LinkedList<Block>();


    /**
     * Occurs at every game tick.
     */
    public void tick() {
        for(int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
        }
    }

    /**
     * Renders every block that is in the list
     * @param g graphics object
     */
    public void render(Graphics g) {
        for(int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            block.render(g);
        }
    }

    /**
     * Called to create a block and add it to the list
     * @param block
     */
    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    /**
     * Called when block is destroyed by the player
     * @param block
     */
    public void removeBlock(Block block) {
        numBlocksKilled++;
        this.blocks.remove(block);
    }

    /**
     * Used for the score count in the hud
     * @return number of blocks that have been shot
     */
    public int getNumBlocksKilled() {
        return numBlocksKilled;
    }


    /**
     * Keeps count of number of blocks that have spawned thus far to
     * make sure that blocks stop being made when timer ends
     * @return number of blocks created thus far
     */
    public int getNumBlocksSpawned() {
        return numBlocksSpawned;
    }

}

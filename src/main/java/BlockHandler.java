import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * Updates and renders all block objects
 */
public class BlockHandler {

    private int numBlocksKilled = 0;
    private int numBlocksSpawned = 0;

    private int mouseClickX;
    private int mouseClickY;

    LinkedList<Block> blocks = new LinkedList<Block>();

    /**
     * Occurs at every game tick.
     */
    public void tick() {
        for(int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);

            if(blockIsClicked(block)) {
                removeBlock(block);
            }
        }
    }

    /**
     * Indicates whether or not a block has been hit
     *
     * @param block block which is being considered for hit detection
     * @return true if block has been clicked, false otherwise
     */
    protected boolean blockIsClicked(Block block) {
        if(
                getMouseClickX() > block.getX() &&
                getMouseClickY() > block.getY() &&
                getMouseClickX() < block.getX() + Constants.BLOCK_LENGTH &&
                getMouseClickY() < block.getY() + Constants.BLOCK_LENGTH
        ) {
            return true;
        }
        else {
            return false;
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

    /**
     * Used to add 1 to the score every time a block is spawned
     * @param numBlocksSpawned number of blocks that have spawned
     */
    public void setNumBlocksSpawned(int numBlocksSpawned) {
        this.numBlocksSpawned = numBlocksSpawned;
    }

    /**
     * @return x coordinate of mouse click
     */
    public int getMouseClickX() {
        return mouseClickX;
    }

    /**
     * Used by MouseClickListener
     * @see MouseClickListener#mousePressed(MouseEvent) for where MouseClickListener sets this
     * @param mouseClickX mouse-click x coordinate
     */
    public void setMouseClickX(int mouseClickX) {
        this.mouseClickX = mouseClickX;
    }

    /**
     * @return * Returns Y coordinate of mouse click
     */
    public int getMouseClickY() {
        return mouseClickY;
    }

    /**
     * Used by MouseClickListener
     * @see MouseClickListener#mousePressed(MouseEvent) for where MouseClickListener sets this
     * @param mouseClickY mouse-click x coordinate
     */
    public void setMouseClickY(int mouseClickY) {
        this.mouseClickY = mouseClickY;
    }


}

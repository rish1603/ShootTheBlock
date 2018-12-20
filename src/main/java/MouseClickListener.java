import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickListener extends MouseAdapter {

    private BlockHandler handler;

    /**
     * Called by Game.java too create a mouse listening process
     * @param handler blockHandler instance
     */
    public MouseClickListener(BlockHandler handler) {
        this.handler = handler;
    }

    /**
     * Sends mouse press position to BlockHandler for hit-detection
     * @param e contains mouse positioning data
     */
    @Override
    public void mousePressed(MouseEvent e) {
        handler.setMouseClickX(e.getX());
        handler.setMouseClickY(e.getY());
    }
}

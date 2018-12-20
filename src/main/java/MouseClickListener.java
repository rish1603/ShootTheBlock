import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickListener extends MouseAdapter {

    private BlockHandler handler;

    public MouseClickListener(BlockHandler handler) {
        this.handler = handler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
    }
}

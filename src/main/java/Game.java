import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private Thread thread;
    private boolean running = false;

    public Game() {
        new Window(Constants.GAME_NAME, this);
    }

    /**
     * Creates thread and starts game
     */
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Occurs when game has ended
     */
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running) {
                render();
                frames++;
            }
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("fps: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {

    }

    /**
     * Renders image onto the screen, creates background colour
     */
    private void render() {

        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, Constants.INITIAL_WIDTH, Constants.INITIAL_HEIGHT);

        g.dispose();
        bs.show();

    }

    public static void main(String args[]) {
        new Game();
    }

}


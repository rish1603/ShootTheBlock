import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends Canvas implements Runnable{

    private Thread thread;
    private BlockHandler handler;
    private HUD hud;
    private boolean running = false;
    private Window window;

    /**
     * Constructor that creates the game window
     */
    public Game() {
        handler = new BlockHandler();
        this.addMouseListener(new MouseClickListener(handler));
        window = new Window(Constants.GAME_NAME, this);
        hud = new HUD();
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

    /**
     * Game loop which also measures time remaining
     */
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        startTimer();
        spawnBoxes();

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
            }
        }
        stop();
    }

    private void spawnBoxes() {

        long interval = Constants.BLOCK_SPAWN_INTERVAL;
        final int totalBoxes = (Constants.GAME_TIME * 1000) / Constants.BLOCK_SPAWN_INTERVAL;

        Timer timer = new Timer();
        TimerTask handleSpawn = new TimerTask() {
            public void run() {
                if(handler.getNumBlocksSpawned() == totalBoxes) {
                    cancel();
                }
                else {
                    Block block = new Block();
                    handler.addBlock(block);
                }
            }
        };
        timer.scheduleAtFixedRate(handleSpawn, 0, interval);
    }

    private void startTimer() {

        long second = 1000L;

        Timer timer = new Timer();
        TimerTask handleSecond = new TimerTask() {
            public void run() {
                if(hud.getTimeRemaining() == 0) {
                    cancel();
                    //end game
                }
                else {
                    hud.setTimeRemaining(hud.getTimeRemaining() - 1);
                }
            }
        };
        timer.scheduleAtFixedRate(handleSecond, second, second);
    }

    private void tick() {
        handler.tick();
        hud.tick();
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

        g.setColor(Color.white);
        g.fillRect(0, 0, Constants.INITIAL_WIDTH, Constants.INITIAL_HEIGHT);

        hud.render(g);
        handler.render(g);

        g.dispose();
        bs.show();

    }

    /**
     * Main method that is run to launch the game
     * @param args
     */
    public static void main(String args[]) {
        new Game();
    }

}


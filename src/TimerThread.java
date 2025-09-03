package app;

public class TimerThread extends Thread {
    private volatile boolean running = true;
    private final long start = System.currentTimeMillis();

    public TimerThread() {
        setDaemon(true);
    }

    public void stopTimer() {
        long elapsed = (System.currentTimeMillis() - start) / 1000;
        String color = Colors.RAINBOW[(int)(elapsed % app.Colors.RAINBOW.length)];
        System.out.print("\r" + color + "⏳ Temps écoulé : " + elapsed + "s" + Colors.RESET);
        running = false;
    }

    @Override
    public void run() {
        int i = 0;
        while (running) {
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            i++;
        }
        // clear the timer line
        System.out.print("\r\033[K");
    }
}

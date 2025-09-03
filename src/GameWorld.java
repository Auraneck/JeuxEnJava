package app;

import java.util.Scanner;

public final class GameWorld {
    private static final int[][] MAP = new int[][]{
        {1,1,1,1,1,1,1,1,1},
        {1,0,0,3,0,4,0,2,1},
        {1,0,1,1,0,1,1,0,1},
        {1,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1},
    };
    private static int py = 1, px = 1;
    private static final String SMILE = "☺";
    private static final String DOOR  = "𖤘";
    private static final String KEY   = "🔑";

    private GameWorld(){}

    private static void draw() {
        StringBuilder sb = new StringBuilder();
        for (int y=0;y<MAP.length;y++) {
            for (int x=0;x<MAP[0].length;x++) {
                if (y==py && x==px) { sb.append(SMILE); continue; }
                int v = MAP[y][x];
                switch (v) {
                    case 1 -> sb.append("█");
                    case 2 -> sb.append(DOOR);
                    case 3 -> sb.append("•");
                    case 4 -> sb.append(KEY);
                    default -> sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        System.out.println("(ZQSD pour bouger, Entrée pour valider la touche)");
    }

    public static void play(Scanner sc) {
        Terminal.clearScreen();
        Terminal.printHeader("Aventure");
        boolean haveKey = false;
        while (true) {
            Terminal.clearScreen();
            Terminal.printHeader("Aventure");
            draw();
            System.out.print("Touche (z/q/s/d) : ");
            String line = sc.nextLine().trim().toLowerCase();
            if (line.isEmpty()) continue;
            char key = line.charAt(0);
            int ny = py, nx = px;
            if (key=='z') ny = py-1;
            else if (key=='s') ny = py+1;
            else if (key=='q') nx = px-1;
            else if (key=='d') nx = px+1;
            else continue;
            if (MAP[ny][nx] != 1) {
                py = ny; px = nx;
                if (MAP[ny][nx] == 4) { haveKey = true; MAP[ny][nx] = 0; }
                if (MAP[ny][nx] == 3) {
                    StepDevineCode.play(sc);
                }
                if (MAP[ny][nx] == 2) {
                    if (!haveKey) {
                        System.out.println(Colors.RED + "La porte est verrouillée. Trouve la clé." + Colors.RESET);
                        try { Thread.sleep(1000);} catch (InterruptedException ignored){}
                    } else {
                        // mini-jeux enchaînés comme en Python
                        StepDevineCode.play(sc);
                        StepCryptedMessage.play(sc);
                        StepCadenasLogique.play(sc);
                        return;
                    }
                }
            }
        }
    }
}

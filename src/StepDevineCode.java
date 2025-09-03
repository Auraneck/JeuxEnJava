package app;

import java.util.Random;
import java.util.Scanner;

public final class StepDevineCode {
    private StepDevineCode(){}

    public static boolean play(Scanner sc) {
        Terminal.clearScreen();
        Random rnd = new Random();
        int code = 1 + rnd.nextInt(99);
        String feedback = "";
        while (true) {
            Terminal.clearScreen();
            System.out.println(Colors.YELLOW + "Devine le code (entre 1 et 99)." + Colors.RESET);
            if (!feedback.isEmpty()) System.out.println(feedback);
            System.out.print(Colors.YELLOW + "→ " + Colors.RESET);
            String line = sc.nextLine().trim();
            int guess;
            try {
                guess = Integer.parseInt(line);
            } catch (Exception e) {
                feedback = Colors.RED + "Entier requis, réessayez." + Colors.RESET;
                continue;
            }
            if (guess < code) {
                feedback = Colors.RED + "Trop petit." + Colors.RESET;
            } else if (guess > code) {
                feedback = Colors.RED + "Trop grand." + Colors.RESET;
            } else {
                Terminal.clearScreen();
                System.out.println(Colors.GREEN + "╔════════╗\n║ Bravo! ║\n╚════════╝" + Colors.RESET);
                try { Thread.sleep(1000);} catch (InterruptedException ignored){}
                return true;
            }
        }
    }
}

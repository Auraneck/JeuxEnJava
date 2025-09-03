package app;

import java.util.Scanner;

public class Main {
    private static void runWithTimer(Runnable r) {
        Terminal.clearScreen();
        TimerThread t = new TimerThread();
        t.start();
        try { r.run(); }
        finally { t.stopTimer(); }
    }

    private static void miniGames(Scanner sc) {
        while (true) {
            Terminal.clearScreen();
            Terminal.printHeader("Mini-jeux");
            System.out.println("1) Devine le code");
            System.out.println("2) Message chiffré (César)");
            System.out.println("3) Cadenas logique (villes/pays)");
            System.out.println("4) Retour");
            System.out.print("Choix: ");
            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1" -> runWithTimer(() -> StepDevineCode.play(sc));
                case "2" -> runWithTimer(() -> StepCryptedMessage.play(sc));
                case "3" -> runWithTimer(() -> StepCadenasLogique.play(sc));
                case "4" -> { return; }
                default -> {}
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Terminal.clearScreen();
            Terminal.printHeader("Escape Room (Java)");
            System.out.println("1) Aventure");
            System.out.println("2) Mini-jeux");
            System.out.println("3) Quitter");
            System.out.print("Choix: ");
            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1" -> runWithTimer(() -> GameWorld.play(sc));
                case "2" -> miniGames(sc);
                case "3" -> {
                    Terminal.clearScreen();
                    System.out.println("A bientôt !");
                    System.exit(0);
                }
                default -> {}
            }
        }
    }
}

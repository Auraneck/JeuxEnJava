package app;

import java.util.Random;
import java.util.Scanner;

public final class StepCryptedMessage {
    private StepCryptedMessage(){}

    public static boolean play(Scanner sc) {
        Terminal.clearScreen();
        String[] messages = new String[]{"BONJOUR","ESCAPE","PYTHON","SECRET"};
        Random rnd = new Random();
        String plain = messages[rnd.nextInt(messages.length)];
        int shift = 1 + rnd.nextInt(25);
        String crypted = Crypto.caesarShift(plain, shift);
        while (true) {
            Terminal.clearScreen();
            System.out.println("Clé de décalage : " + shift);
            System.out.println("Message chiffré : " + crypted);
            System.out.print(Colors.YELLOW + "Ta réponse (texte en clair) : " + Colors.RESET);
            String ans = sc.nextLine().trim().toUpperCase();
            if (ans.equals(plain)) {
                System.out.println(Colors.GREEN + "✔ Correct!" + Colors.RESET);
                try { Thread.sleep(1000);} catch (InterruptedException ignored){}
                return true;
            } else {
                System.out.println(Colors.RED + "✖ Raté, réessaie." + Colors.RESET);
                try { Thread.sleep(800);} catch (InterruptedException ignored){}
            }
        }
    }
}

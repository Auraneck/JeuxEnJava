package app;

import java.util.*;

public final class StepCadenasLogique {
    private StepCadenasLogique(){}

    public static boolean play(Scanner sc) {
        Terminal.clearScreen();
        Map<String,String> pairs = Map.of(
            "Paris", "France",
            "Berlin", "Allemagne",
            "Rome", "Italie",
            "Madrid", "Espagne"
        );
        List<String> villes = new ArrayList<>(pairs.keySet());
        Collections.shuffle(villes, new Random());
        List<String> pays = new ArrayList<>(pairs.values());
        Collections.shuffle(pays, new Random());

        Map<String,String> correspondances = new LinkedHashMap<>();
        while (true) {
            Terminal.clearScreen();
            System.out.println("Associe chaque ville au bon pays (réponds par le numéro).\n");
            for (int i=0;i<pays.size();i++) {
                System.out.printf("  %d. %s%n", i+1, pays.get(i));
            }
            System.out.println();
            correspondances.clear();
            for (int i=0;i<villes.size();i++) {
                System.out.printf(Colors.YELLOW + "%d → Quel est le numéro du pays pour '%s' ? " + Colors.RESET, i+1, villes.get(i));
                String line = sc.nextLine().trim();
                int idx;
                try {
                    idx = Integer.parseInt(line);
                } catch (Exception e) {
                    i--; // redo this one
                    continue;
                }
                if (idx < 1 || idx > pays.size()) {
                    i--;
                    continue;
                }
                correspondances.put(villes.get(i), pays.get(idx-1));
            }
            int score = 0;
            System.out.println();
            for (Map.Entry<String,String> e : correspondances.entrySet()) {
                String ville = e.getKey();
                String donné = e.getValue();
                String attendu = pairs.get(ville);
                if (attendu.equals(donné)) {
                    System.out.println(Colors.GREEN + "✔ " + ville + " → " + donné + Colors.RESET);
                    score++;
                } else {
                    System.out.println(Colors.RED + "✖ " + ville + " → " + donné + "   (attendu : " + attendu + ")" + Colors.RESET);
                }
            }
            System.out.println();
            System.out.println(Colors.RAINBOW[0] + "Score final : " + score + "/" + villes.size() + Colors.RESET);
            if (score == villes.size()) {
                System.out.println(Colors.GREEN + "╔═════════════╗\n║   GAGNÉ !   ║\n╚═════════════╝" + Colors.RESET);
                try { Thread.sleep(1500);} catch (InterruptedException ignored){}
                return true;
            } else {
                System.out.print(Colors.YELLOW + "Recommencer ? (o/n) " + Colors.RESET);
                String again = sc.nextLine().trim().toLowerCase();
                if (!again.startsWith("o")) return false;
                Collections.shuffle(villes);
                Collections.shuffle(pays);
            }
        }
    }
}

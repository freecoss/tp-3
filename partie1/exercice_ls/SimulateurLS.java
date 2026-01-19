package partie1.exercice_ls;

import java.io.File;
import java.util.Scanner;

public class SimulateurLS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le chemin absolu du répertoire : ");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Le chemin spécifié n'existe pas ou n'est pas un répertoire.");
            return;
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                String type = file.isDirectory() ? "<DIR>" : "<FILE>";
                String r = file.canRead() ? "r" : "-";
                String w = file.canWrite() ? "w" : "-";
                String h = file.isHidden() ? "h" : "-";
                
                System.out.printf("%s %s %s%s%s%n", file.getAbsolutePath(), type, r, w, h);
            }
        }
    }
}

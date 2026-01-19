package partie1.exercice_serialization;

import java.util.Scanner;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl("products.dat");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu :\n");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Sauvegarder les produits.");
            System.out.println("6. Quitter.");
            System.out.print("Choisissez une option : ");
            
            String choiceStr = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        List<Product> list = metier.getAll();
                        if (list.isEmpty()) {
                            System.out.println("Aucun produit dans la liste.");
                        } else {
                            for (Product p : list) {
                                System.out.println(p);
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Entrez l'ID : ");
                        long idSearch = Long.parseLong(scanner.nextLine());
                        Product p = metier.findById(idSearch);
                        if (p != null) System.out.println(p);
                        else System.out.println("Produit non trouvé.");
                        break;
                    case 3:
                        System.out.print("Entrez l'ID : ");
                        long id = Long.parseLong(scanner.nextLine());
                        System.out.print("Entrez le nom : ");
                        String name = scanner.nextLine();
                        System.out.print("Entrez la marque : ");
                        String brand = scanner.nextLine();
                        System.out.print("Entrez le prix : ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Entrez la description : ");
                        String desc = scanner.nextLine();
                        System.out.print("Entrez le stock : ");
                        int stock = Integer.parseInt(scanner.nextLine());
                        
                        Product newP = new Product(id, name, brand, price, desc, stock);
                        metier.add(newP);
                        System.out.println("Produit ajouté.");
                        break;
                    case 4:
                        System.out.print("Entrez l'ID à supprimer : ");
                        long idDel = Long.parseLong(scanner.nextLine());
                        metier.delete(idDel);
                        System.out.println("Produit supprimé (si existant).");
                        break;
                    case 5:
                        metier.saveAll();
                        System.out.println("Produits sauvegardés.");
                        break;
                    case 6:
                        System.out.println("Au revoir.");
                        return;
                    default:
                        System.out.println("Option invalide.");
                }
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}

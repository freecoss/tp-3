package partie1.exercice_serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IProduitMetier {
    private List<Product> products = new ArrayList<>();
    private String fileName;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        File f = new File(fileName);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                Object obj = ois.readObject();
                if (obj instanceof List) {
                    products = (List<Product>) obj;
                }
            } catch (Exception e) {
                System.err.println("Erreur lors du chargement initial : " + e.getMessage());
            }
        }
    }

    @Override
    public void add(Product p) {
        products.add(p);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product findById(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}

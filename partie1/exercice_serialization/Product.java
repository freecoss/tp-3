package partie1.exercice_serialization;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int stock;

    public Product(long id, String name, String brand, double price, String description, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id + ", "
                + "name='" + name + "'" + ", "
                + "brand='" + brand + "'" + ", "
                + "price=" + price + ", "
                + "description='" + description + "'" + ", "
                + "stock=" + stock + 
                '}';
    }
}

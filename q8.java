abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    abstract void displayInfo();
}

class Fruit extends Product {
    public Fruit(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public void displayInfo() {
        System.out.println("Fruit: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println();
    }
}

class Vegetable extends Product {
    public Vegetable(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public void displayInfo() {
        System.out.println("Vegetable: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println();
    }
}

class Grocery extends Product {
    public Grocery(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public void displayInfo() {
        System.out.println("Grocery: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println();
    }
}

class RetailStore {
    private Product[] products;
    private int productCount;

    public RetailStore(int size) {
        this.products = new Product[size];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Store is full. Cannot add more products.");
        }
    }

    public void editProduct(String name, double price, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                products[i].setPrice(price);
                products[i].setQuantity(quantity);
                System.out.println("Product " + name + " updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void removeProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--productCount] = null;
                System.out.println("Product " + name + " removed.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void displayProducts() {
        if (productCount == 0) {
            System.out.println("No products available.");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            products[i].displayInfo();
        }
    }
}
public class q8 {
    public static void main(String[] args) {
        RetailStore store = new RetailStore(5);

        Product apple = new Fruit("Apple", 2.5, 50);
        Product carrot = new Vegetable("Carrot", 1.2, 30);
        Product rice = new Grocery("Rice", 3.0, 100);

        store.addProduct(apple);
        store.addProduct(carrot);
        store.addProduct(rice);

        System.out.println("Products in Store:");
        store.displayProducts();

        store.editProduct("Apple", 2.8, 60);

        System.out.println("Updated Products:");
        store.displayProducts();

        store.removeProduct("Carrot");

        System.out.println("Products after removal:");
        store.displayProducts();
    }
}

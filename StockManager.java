import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version 7.0
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stockList;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stockList = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        int itemID = item.getID();
        if(findProduct(itemID) == null){
            stockList.add(item);
        } else {
            System.out.println("ID already in use.");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product targetedProduct = findProduct(id);
        if(targetedProduct != null){
            targetedProduct.increaseQuantity(amount);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for (Product product : stockList){
            int targetedProductID = product.getID();
            if(id == targetedProductID){
                return product;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product targetedProduct = findProduct(id);
        if(targetedProduct != null){
            return targetedProduct.getQuantity();
        }
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product product : stockList){
            System.out.println(product.toString());
        }
    }
    
    public void printDetailsOfStockBelow(int quantity){
        for(Product product : stockList){
            int productQuantity = product.getQuantity();
            if (productQuantity < quantity){
                System.out.println(product.toString());
            }
        }
    }
    
    public Product findProduct(String name){
        for (Product product : stockList){
            String targetedProductName = product.getName();
            if (name.equals(targetedProductName)){
                return product;
            }
        }
        return null;
    }
}

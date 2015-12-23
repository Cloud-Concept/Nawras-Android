package model;

/**
 * Created by Bibo on 12/21/15.
 */
public class GenericItem {

    String productName;
    String Quantity;
    String Facing;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getFacing() {
        return Facing;
    }

    public void setFacing(String facing) {
        Facing = facing;
    }
}

package vn.edu.iuh.fit.www_lab07.dto;

public class ProductDTO {
    private long id;
    private String productName;
    private String path;
    private double quantity;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(long id, String productName, String path, double quantity, double price) {
        this.id = id;
        this.productName = productName;
        this.path = path;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", path='" + path + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

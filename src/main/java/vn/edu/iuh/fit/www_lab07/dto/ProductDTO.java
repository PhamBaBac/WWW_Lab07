package vn.edu.iuh.fit.www_lab07.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private long id;
    private String productName;
    private String description;
    private String path;
    private double quantity;
    private double price;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

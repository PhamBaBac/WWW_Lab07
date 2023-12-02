package vn.edu.iuh.fit.www_lab07.utils;

import vn.edu.iuh.fit.www_lab07.dto.ProductDTO;
import vn.edu.iuh.fit.www_lab07.models.Product;

public class ProductUtil {

    public static ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getProduct_id());
        productDTO.setProductName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPath(product.getProductImageList().get(0).getPath());
        productDTO.setPrice(product.getProductPrices().get(0).getPrice());
        return productDTO;
    }

    // You can add a method to convert a list of entities to DTOs if needed
}
